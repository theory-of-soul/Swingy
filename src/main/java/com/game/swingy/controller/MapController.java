package com.game.swingy.controller;

import com.game.swingy.core.Coordinates;
import com.game.swingy.core.GameButtonListener;
import com.game.swingy.core.Map;
import com.game.swingy.core.Unit;
import com.game.swingy.view.gui.HeroStatisticsView;
import com.game.swingy.view.gui.MapView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
                if (i == (x - 1) && j == y && (x - 1) < mapSize && (x - 1) > 0)
                    mapView.btnUnitsActivated(i, y);
                else if (i == x && j == (y - 1) && (x - 1) < mapSize && (x - 1) > 0)
                    mapView.btnUnitsActivated(i, y);
                else if (i == x && j == (y + 1) && (x - 1) < mapSize && (x - 1) > 0)
                    mapView.btnUnitsActivated(i, y);
                else if (i == (x + 1) && j == (y) && (x - 1) < mapSize && (x - 1) > 0)
                    mapView.btnUnitsActivated(i, y);
                else if (i == x && j == y && (x - 1) < mapSize && (x - 1) > 0)
                    mapView.btnUnitsActivated(i, y);
                else
                    mapView.btnUnitsDeActivated(i,j);
            }
        }
    }

    public void initMoveHero() {

        int x = Map.getMap().getObservers().get(0).getCoordinates().getX();
        int y = Map.getMap().getObservers().get(0).getCoordinates().getY();

        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                if (x == i && y == j) {
                    mapView.getBtnUnits()[i][j].addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            onClickHeroButton();
                        }
                    });
                }
                else if (checkXYInUnitList(i, j)) {
                    mapView.getBtnUnits()[i][j].addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            onClickVillainsButton();
                        }
                    });
                }
                else {
                    mapView.getBtnUnits()[i][j].addActionListener(new GameButtonListener(i, j) {
                        public void actionPerformed(ActionEvent e) {
                            onClickEmptyButton(this.getCoordinateX(),this.getCoordinateY());
                        }
                    });
                }
            }
        }
    }

    public void onClickHeroButton() {
        //TODO показати вікно з даними про гравця
        System.out.println("On Hero");
        HeroStatisticsView heroStatisticsView = new HeroStatisticsView();
    }

    public void onClickVillainsButton() {
        System.out.println("On Villian");
    }

    public void onClickEmptyButton(int x, int y) {

        System.out.println("Empty");
        System.out.println(x);
        System.out.println(y);
//        changeHeroPosition(x, y);
//        mapView.setHeroIcon(x, y);
    }

    public void changeHeroPosition(int toX, int toY) {

        int x = Map.getMap().getObservers().get(0).getCoordinates().getX();
        int y = Map.getMap().getObservers().get(0).getCoordinates().getY();

        Map.getMap().getObservers().get(0).getCoordinates().setX(toX);
        Map.getMap().getObservers().get(0).getCoordinates().setY(toY);
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
}

//TODO не првильно заповнюється герой і вороги. Помилка скоріше в віртуальному конструкторі
//розібратися як її пофіксити і перевірити рендомайзер кординат
