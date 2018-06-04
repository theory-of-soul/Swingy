package com.game.swingy.core;

import java.util.ArrayList;
import java.util.List;

public class Map {

    private static Map map;
    private Map(){

    }

    public static Map getMap(){

        if(map == null)
            map = new Map();
        return map;
    }
    private List<Hero> observers = new ArrayList<Hero>();

    public void register(Hero hero) {

        if (observers.contains(hero))
            return;
        observers.add(hero);
    }
    public void unregister(Hero hero) {

        observers.remove(hero);
    }

    public List<Hero> getObservers() {
        return observers;
    }
}
