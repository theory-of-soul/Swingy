package com.game.swingy.controller;

import com.game.swingy.core.Coordinates;
import com.game.swingy.core.Map;
import com.game.swingy.core.Unit;
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
                else {
                    mapView.getBtnUnits()[i][j].addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            onClickVillainsButton();
                        }
                    });
                }
            }
        }
    }

    public void onClickHeroButton() {
        //TODO показати вікно з даними про гравця
    }

    public void onClickVillainsButton() {

    }

    public void changeHeroPosition(int toX, int toY) {

        int x = Map.getMap().getObservers().get(0).getCoordinates().getX();
        int y = Map.getMap().getObservers().get(0).getCoordinates().getY();

        Map.getMap().getObservers().get(0).getCoordinates().setX(toX);
        Map.getMap().getObservers().get(0).getCoordinates().setY(toY);
    }

    public void changeLableButton() {

        int x = Map.getMap().getObservers().get(0).getCoordinates().getX();
        int y = Map.getMap().getObservers().get(0).getCoordinates().getY();

        mapView.changeIconButton(x, y);
    }

    static private boolean checkXYInUnitList(int x, int y) {

        if (Map.getMap().getObservers().get(0).getCoordinates().getX() == x
                && Map.getMap().getObservers().get(0).getCoordinates().getY() == y)
            return false;

        List<Unit> unit = Map.getMap().getObservers();
        for (Unit one:
             unit) {
            if (one.getCoordinates().getX() == x && one.getCoordinates().getY() == y)
                return true;
        }
        return false;
    }

    public void setRendomCoordinats() {

        Random random = new Random();
        int length = Map.getMap().getObservers().size() - 1;
        List<Unit> units = Map.getMap().getObservers();
        for (int i = 1; i < length; i++) {
            int x = random.nextInt(mapSize);
            int y = random.nextInt(mapSize);
            if (!checkXYInUnitList(units.get(i).getCoordinates().getX(), units.get(i).getCoordinates().getY())) {
                if (checkXYInUnitList(units.get(i).getCoordinates().getX(), units.get(i).getCoordinates().getY())) {
                    x = random.nextInt(mapSize);
                    y = random.nextInt(mapSize);
                }
            }
            else {
                Coordinates coordinates = new Coordinates(x, y);
                units.get(i).setCoordinates(coordinates);
                mapView.setVilliansIcon(x, y);
            }

        }
    }
}

//TODO не првильно заповнюється герой і вороги. Помилка скоріше в віртуальному конструкторі
//розібратися як її пофіксити і перевірити рендомайзер кординат
