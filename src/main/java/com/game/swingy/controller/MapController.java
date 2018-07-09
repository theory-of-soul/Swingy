package com.game.swingy.controller;

import com.game.swingy.core.DataBase.DbMySQL;
import com.game.swingy.core.Map.EmptyButtonListener;
import com.game.swingy.core.Map.Map;
import com.game.swingy.core.Unit.Coordinates;
import com.game.swingy.core.Unit.Unit;
import com.game.swingy.view.gui.MapView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.Random;

public class MapController {

    private int mapSize;
    private MapView mapView;
    private DbMySQL dbMySQL;


    public MapController(List<Unit> unit) {

        int level = Map.getMap().getObservers().get(0).getLevel();

        mapSize = getMapSize(level);
        mapView = new MapView(mapSize);
        dbMySQL = new DbMySQL();
        deAndActivatedbtnUnits();
        setRandomCoordinates();
        initMoveHero();
        initCloseLisener();
    }

    static private int getMapSize(int heroLevel){

        return (heroLevel - 1) * 5 + 10 - (heroLevel % 2);
    }

    private void deAndActivatedbtnUnits() {

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

    private void initMoveHero() {

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

    private void initCloseLisener() {

        mapView.getJf().addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                int confirmed = JOptionPane.showConfirmDialog(null,
                        "Are you sure you want to close current game with save?",
                        "Close Swingy Message Box",
                        JOptionPane.YES_NO_OPTION);

                if (confirmed == 0) {
                    fillDataBase();
                    Map.getMap().deleteVillainFromListofUnit();
                    Map.getMap().deleteHeroFromListOfVillain();
                    mapView.getJf().dispose();
                    //mapView = null;
                }
                else
                    mapView.getJf().setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
            }
        });



        /*mapView.getJf().addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                fillDataBase();
            }
        });*/
    }

    private void fillDataBase() {

        List<Unit> unit = Map.getMap().getObservers();
        for (Unit one: unit) {
            dbMySQL.fillUnitTable(one);
        }
    }

    public void onClickButton(int x, int y) {

        int heroX = Map.getMap().getObservers().get(0).getCoordinates().getX();
        int heroY = Map.getMap().getObservers().get(0).getCoordinates().getY();

        if (heroX == x && heroY == y) {
            onClickHeroButton();
        }
        else if (checkXYInUnitList(x, y)) {
            onClickVillainsButton(x, y);
        }
        else {
            onClickEmptyButton(x, y);
        }

    }
    public void onClickHeroButton() {
        System.out.println("On Hero");
        StatisticsController statisticsController = new StatisticsController();
        statisticsController.setHeroFields();
    }

    public void onClickVillainsButton(int x, int y) {
        System.out.println("On Villain");
        Unit villain = getVillian(x, y);
        mapView.getJf().setVisible(false);
        VillianAllertController villianAllertController = new
                VillianAllertController(villain,this);
        System.out.println("yes on villain button");
    }


    public void onClickEmptyButton(int x, int y) {

        System.out.println("Empty");
        changeHeroPosition(x, y);

    }

    public void changeHeroPosition(int toX, int toY) {

        int x = Map.getMap().getObservers().get(0).getCoordinates().getX();
        int y = Map.getMap().getObservers().get(0).getCoordinates().getY();
        mapView.setEmptyIcon(x, y);
        mapView.setHeroIcon(toX, toY);
        Map.getMap().getObservers().get(0).getCoordinates().setX(toX);
        Map.getMap().getObservers().get(0).getCoordinates().setY(toY);
        deAndActivatedbtnUnits();
        isCheckWinner();
    }

    public void heroKilledVillain(Unit villain) {

        changeHeroPosition(villain.getCoordinates().getX(), villain.getCoordinates().getY());
        Map.getMap().unregister(villain);
    }

    /*public void changeIconButton() {

        int x = Map.getMap().getObservers().get(0).getCoordinates().getX();
        int y = Map.getMap().getObservers().get(0).getCoordinates().getY();

        mapView.changeIconButton(x, y);
    }*/

    static private Unit getVillian(int x, int y) {

        List<Unit> unit = Map.getMap().getObservers();
        for (Unit one: unit) {
            if (one.getCoordinates().getX() == x && one.getCoordinates().getY() == y)
                return one;
        }
        throw new Error("Not valid x and y coordinats");
    }
    static private boolean checkXYInUnitList(int x, int y) {

        List<Unit> unit = Map.getMap().getObservers();
        for (Unit one: unit) {
            if (one.getCoordinates().getX() == x && one.getCoordinates().getY() == y)
                return true;
        }
        return false;
    }

    public void setRandomCoordinates() {

        Random random = new Random();
        int length = Map.getMap().getObservers().size();
        List<Unit> units = Map.getMap().getObservers();
        for (int i = 1; i < length; i++) {
            if (units.get(i).getCoordinates().getX() == -1 && units.get(i).getCoordinates().getY() == -1) {
                int x = random.nextInt(mapSize);
                int y = random.nextInt(mapSize);
                if (checkXYInUnitList(x, y)) {
                    this.setRandomCoordinates();
                } else {
                    Coordinates coordinates = new Coordinates(x, y);
                    units.get(i).setCoordinates(coordinates);
                    mapView.setVilliansIcon(x, y);
                }
            }
        }
    }

    private void isCheckWinner() {

        int x = Map.getMap().getObservers().get(0).getCoordinates().getX();
        int y = Map.getMap().getObservers().get(0).getCoordinates().getY();

        if (x == 0 || y == 0 || x == getMapSize() - 1 ||
                y == getMapSize() - 1) {
            System.out.println("Mission completed");
            mapView.showMissionCompletedView();
            Map.getMap().deleteVillainFromListofUnit();
            //mapView.closeWindow();
            //mapView.getJf().setVisible(false);
            mapView.getJf().dispose();
            mapView = null;
            Map.getMap().fillListOfVillain();
        }
    }

    public JFrame getMapViewFrame() {
        return mapView.getJf();
    }

    public void closeMapView() {
        mapView.closeWindow();
    }

    public int getMapSize() {
        return mapSize;
    }

    public MapView getMapView() {
        return mapView;
    }
}