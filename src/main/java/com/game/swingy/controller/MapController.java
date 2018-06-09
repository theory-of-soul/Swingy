package com.game.swingy.controller;

import com.game.swingy.core.Coordinates;
import com.game.swingy.core.EmptyButtonListener;
import com.game.swingy.core.Map;
import com.game.swingy.core.Unit;
import com.game.swingy.view.gui.HeroStatisticsView;
import com.game.swingy.view.gui.MapView;

import java.awt.event.ActionEvent;
import java.util.List;
import java.util.Random;

public class MapController {

    private int mapSize;
    private MapView mapView;

    public MapController(List<Unit> unit) {

        int level = Map.getMap().getObservers().get(0).getLevel();

        mapSize = getMapSize(level);
        mapView = new MapView(mapSize);
    }

    static private int getMapSize(int heroLevel){

        return (heroLevel - 1) * 5 + 10 - (heroLevel % 2);
    }

    public void deAndActivatedbtnUnits() {

        int x = Map.getMap().getObservers().get(0).getCoordinates().getX();
        int y = Map.getMap().getObservers().get(0).getCoordinates().getY();
        System.out.println("x = " + x + "\ny = " + y);
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++){
                if (i == (x - 1) && j == y && (x - 1) < mapSize && (x - 1) >= 0)//рухаємся в гору
                    mapView.btnUnitsActivated(i, j);
                else if (i == (x + 1) && j == (y) && (x + 1) < mapSize && (x + 1) >= 0)
                    mapView.btnUnitsActivated(i, j);
                else if (i == x && j == (y - 1) && (y - 1) < mapSize && (y - 1) >= 0)//рухаємся в ліво
                    mapView.btnUnitsActivated(i, j);
                else if (i == x && j == (y + 1) && (y + 1) < mapSize && (y + 1) >= 0)//рухаємся в право
                    mapView.btnUnitsActivated(i, j);
                else if (i == x && j == y)
                    mapView.btnUnitsActivated(i, j);
                else
                    mapView.btnUnitsDeActivated(i,j);
            }
        }
    }

    public void initMoveHero() {

        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                mapView.getBtnUnits()[i][j].addActionListener(new EmptyButtonListener(i, j) {
                    public void actionPerformed(ActionEvent e) {
                        onClickButton(this.getCoordinateX(), this.getCoordinateY());
                    }
                });
            }
        }
    }

    public void onClickButton(int x, int y) {

        int heroX = Map.getMap().getObservers().get(0).getCoordinates().getX();
        int heroY = Map.getMap().getObservers().get(0).getCoordinates().getY();

        if (heroX == x && heroY == y) {
            onClickHeroButton();
        }
        else if (checkXYInUnitList(x, y)) {
            onClickVillainsButton();
        }
        else {
            onClickEmptyButton(x, y);
        }

    }
    public void onClickHeroButton() {
        //TODO показати вікно з даними про гравця
        System.out.println("On Hero");
        StatisticsController statisticsController = new StatisticsController();
        statisticsController.setHeroFields();
    }

    public void onClickVillainsButton() {
        System.out.println("On Villian");
    }

    public void onClickEmptyButton(int x, int y) {

        System.out.println("Empty");
        changeHeroPosition(x, y);

    }

    private void changeHeroPosition(int toX, int toY) {

        int x = Map.getMap().getObservers().get(0).getCoordinates().getX();
        int y = Map.getMap().getObservers().get(0).getCoordinates().getY();
        mapView.setEmptyIcon(x, y);
        mapView.setHeroIcon(toX, toY);
        Map.getMap().getObservers().get(0).getCoordinates().setX(toX);
        Map.getMap().getObservers().get(0).getCoordinates().setY(toY);
        deAndActivatedbtnUnits();
        checkWinner();
    }

    /*public void changeIconButton() {

        int x = Map.getMap().getObservers().get(0).getCoordinates().getX();
        int y = Map.getMap().getObservers().get(0).getCoordinates().getY();

        mapView.changeIconButton(x, y);
    }*/

    static private boolean checkXYInUnitList(int x, int y) {

        List<Unit> unit = Map.getMap().getObservers();
        for (Unit one:
             unit) {
            if (one.getCoordinates().getX() == x && one.getCoordinates().getY() == y)
                return true;
        }
        return false;
    }

    public void setRandomCoordinats() {

        Random random = new Random();
        int length = Map.getMap().getObservers().size();
        List<Unit> units = Map.getMap().getObservers();
        for (int i = 1; i < length; i++) {
            if (units.get(i).getCoordinates().getX() == -1 && units.get(i).getCoordinates().getY() == -1) {
                int x = random.nextInt(mapSize);
                int y = random.nextInt(mapSize);
                if (checkXYInUnitList(x, y)) {
                    this.setRandomCoordinats();
                } else {
                    Coordinates coordinates = new Coordinates(x, y);
                    units.get(i).setCoordinates(coordinates);
                    mapView.setVilliansIcon(x, y);
                    //mapView.btnUnitsActivated(x, y);//активація кнопок юнітів
                }
            }
        }
    }
    private void checkWinner() {

        int x = Map.getMap().getObservers().get(0).getCoordinates().getX();
        int y = Map.getMap().getObservers().get(0).getCoordinates().getY();

        if (x == 0 || y == 0 || x == mapSize - 1 || y == mapSize - 1)
            System.out.println("Mission completed");
        //TODO вивсти відповідне вікно
        //TODO визначити коли гра закінчиться якщо рівень дойшов до 6
    }
}
