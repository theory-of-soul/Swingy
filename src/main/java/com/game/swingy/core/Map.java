package com.game.swingy.core;

import java.util.ArrayList;
import java.util.List;

public class Map {

    private List<Hero> observers = new ArrayList<Hero>();

    public void register(Hero hero) {

        if (observers.contains(hero))
            return;
        observers.add(hero);
    }
    public void unregister(Hero hero) {

        observers.remove(hero);
    }

}
