package com.game.swingy.core;

import java.util.ArrayList;
import java.util.List;

public class Map {

    private static Map map;
    private List<Unit> observers = new ArrayList<Unit>();
    private boolean isHeroMove = false;

    private Map(){

    }

    public static Map getMap() {

        if(map == null)
            map = new Map();
        return map;
    }

    public void register(Unit unit) {

        if (observers.contains(unit))
            return;
        observers.add(unit);
    }

    public void unregister(Unit unit) {

        observers.remove(unit);
    }

    public List<Unit> getObservers() {
        return observers;
    }


    /*public int getMapSize() {
        if(map == null)
            return 5;
        int heroLevel = Map.getMap().getObservers().get(0).getLevel();
        return (heroLevel - 1) * 5 + 10 - (heroLevel % 2);
    }*/
}
