package com.game.swingy.core.Map;

import com.game.swingy.controller.MapController;
import com.game.swingy.core.Unit.Unit;
import com.game.swingy.core.Unit.UnitBuilder;
import com.game.swingy.core.Unit.UnitConstructor;

import java.util.ArrayList;
import java.util.List;

public class Map {

    private static Map map;
    private List<Unit> observers = new ArrayList<Unit>();
    private int villainX;
    private int villainY;

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

    public void fillListOfVillain() {
        int level = observers.get(0).getLevel();
        int mapSize = getMapSize(level);
        int counterOfVillain = mapSize * mapSize / 2;
            for (int i = (int)(counterOfVillain * 0.7); i > 0; i--) {
                builderVillain(level);
            }
            for (int i = (int)(counterOfVillain * 0.35); i > 0; i--) {
                if (level == 4)
                    builderVillain(level - 1);
                else
                    builderVillain(level + 1);
            }
        MapController mapController = new MapController(observers);
    }

    private void builderVillain(int level) {

        UnitConstructor unitConstructor = new UnitConstructor();
        UnitBuilder unitBuilder = new UnitBuilder();
        switch (level) {
            case 0:
                unitConstructor.constructVillian0(unitBuilder, Integer.toString(level));
                register(unitBuilder.createVillian());
                break;
            case 1:
                unitConstructor.constructVillian1(unitBuilder, Integer.toString(level));
                register(unitBuilder.createVillian());
                break;
            case 2:
                unitConstructor.constructVillian2(unitBuilder, Integer.toString(level));
                register(unitBuilder.createVillian());
                break;
            case 3:
                unitConstructor.constructVillian3(unitBuilder, Integer.toString(level));
                register(unitBuilder.createVillian());
                break;
            case 4:
                unitConstructor.constructVillian4(unitBuilder, Integer.toString(level));
                register(unitBuilder.createVillian());
                break;
        }
    }

    public void deleteVillainFromListofUnit() {
        for (int i = observers.size() - 1; i > 0; i--) {//i = 0 - hero index;
            unregister(observers.get(i));
        }
        observers.get(0).getCoordinates().setX(2);
        observers.get(0).getCoordinates().setY(2);
    }

    public void deleteHeroFromListOfVillain() {
        unregister(observers.get(0));
    }

    static private int getMapSize(int heroLevel){

        return (heroLevel - 1) * 5 + 10 - (heroLevel % 2);
    }

    public int getVillainX() {
        return villainX;
    }

    public void setVillainX(int villainX) {
        this.villainX = villainX;
    }

    public int getVillainY() {
        return villainY;
    }

    public void setVillainY(int villainY) {
        this.villainY = villainY;
    }

    /*public int getMapSize() {
        if(map == null)
            return 5;
        int heroLevel = Map.getMap().getObservers().get(0).getLevel();
        return (heroLevel - 1) * 5 + 10 - (heroLevel % 2);
    }*/
}
