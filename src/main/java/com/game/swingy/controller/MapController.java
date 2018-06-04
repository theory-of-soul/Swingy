package com.game.swingy.controller;

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
}
