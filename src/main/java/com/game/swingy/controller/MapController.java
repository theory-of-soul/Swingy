package com.game.swingy.controller;

import com.game.swingy.core.Map;
import com.game.swingy.view.gui.MapView;

public class MapController {

    private int mapSize;
    private MapView mapView;

    public MapController(int heroLevel) {

        mapSize = mapSize(heroLevel);
        mapView = new MapView(mapSize);
    }

    static private int mapSize(int heroLevel){

        return (heroLevel - 1) * 5 + 10 - (heroLevel % 2);
    }

    public void btnUnitsDeAndActivated() {

        int x = Map.getMap().getObservers().get(0).getCoorditnates().getX();
        int y = Map.getMap().getObservers().get(0).getCoorditnates().getY();
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

    public void changeHeroPosition(int toX, int toY) {

        int x = Map.getMap().getObservers().get(0).getCoorditnates().getX();
        int y = Map.getMap().getObservers().get(0).getCoorditnates().getY();

        Map.getMap().getObservers().get(0).getCoorditnates().setX(toX);
        Map.getMap().getObservers().get(0).getCoorditnates().setY(toY);
    }

    public void changeLableButton() {

        int x = Map.getMap().getObservers().get(0).getCoorditnates().getX();
        int y = Map.getMap().getObservers().get(0).getCoorditnates().getY();

        mapView.changeLableButton(x, y);
    }
}
