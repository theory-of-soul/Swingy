package com.game.swingy.core.Map;

import com.game.swingy.controller.MapController;
import com.game.swingy.core.DataBase.DbMySQL;
import com.game.swingy.core.Unit.*;
import com.game.swingy.view.gui.PreviousHeroView;

import java.util.ArrayList;
import java.util.List;

public class Map {

    private static Map map;
    private List<Unit> observers = new ArrayList<Unit>();
    private PreviousHeroView previousHeroView;
    private DbMySQL dbMySQL = new DbMySQL();
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
            buildVillain(level);
        }
        for (int i = (int)(counterOfVillain * 0.35); i > 0; i--) {
            if (level == 4)
                buildVillain(level - 1);
            else
                buildVillain(level + 1);
        }
        MapController mapController = new MapController();
        mapController.setRandomCoordinates();
    }


    private void buildVillain(int level) {

        UnitConstructor unitConstructor = new UnitConstructor();
        UnitBuilder unitBuilder = new UnitBuilder();
        switch (level) {
            case 0:
                unitConstructor.constructVillian0(unitBuilder, Integer.toString(level));
                break;
            case 1:
                unitConstructor.constructVillian1(unitBuilder, Integer.toString(level));
                break;
            case 2:
                unitConstructor.constructVillian2(unitBuilder, Integer.toString(level));
                break;
            case 3:
                unitConstructor.constructVillian3(unitBuilder, Integer.toString(level));
                break;
            case 4:
                unitConstructor.constructVillian4(unitBuilder, Integer.toString(level));
                break;
        }

        register(unitBuilder.createVillian());
    }

    public void deleteVillainFromListofUnit() {
        for (int i = observers.size() - 1; i > 0; i--) {//i = 0 - hero index;
            unregister(observers.get(i));
        }
        observers.get(0).getCoordinates().setX(2);
        observers.get(0).getCoordinates().setY(2);
    }

    public void deleteHeroFromListOfUnit() {
        unregister(observers.get(0));
    }

    static private int getMapSize(int heroLevel){

        return (heroLevel - 1) * 5 + 10 - (heroLevel % 2);
    }

    public void createPreviousHeroView() {

        previousHeroView = new PreviousHeroView();
    }

    public void loadHero(String []rowData) {
        UnitBuilder unitBuilder = new UnitBuilder();
        Coordinates coordinates = new Coordinates();
        Artefacts artefacts = new Artefacts();
        unitBuilder.setName(rowData[0]);
        unitBuilder.setHeroClass(rowData[1]);
        unitBuilder.setLevel(Integer.parseInt(rowData[2]));
        unitBuilder.setAttack(Integer.parseInt(rowData[3]));
        unitBuilder.setDefense(Integer.parseInt(rowData[4]));
        unitBuilder.setHitPoints(Integer.parseInt(rowData[5]));
        artefacts.setWeapon(Integer.parseInt(rowData[6]));
        artefacts.setArmor(Integer.parseInt(rowData[7]));
        artefacts.setHelm(Integer.parseInt(rowData[8]));
        coordinates.setX(Integer.parseInt(rowData[9]));
        coordinates.setY(Integer.parseInt(rowData[10]));
        unitBuilder.setArtefacts(artefacts);
        unitBuilder.setCoordinates(coordinates);
        if (rowData.length == 12) {
            unitBuilder.setExperience(Integer.parseInt(rowData[11]));
            register(unitBuilder.createHero());
        }
        else
            register(unitBuilder.createVillian());

    }

    public void loadVillain(String []rowData) {


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

    public PreviousHeroView getPreviousHeroView() {
        return previousHeroView;
    }

    public DbMySQL getDbMySQL() {
        return dbMySQL;
    }



    /*public int getMapSize() {
        if(map == null)
            return 5;
        int heroLevel = Map.getMap().getObservers().get(0).getLevel();
        return (heroLevel - 1) * 5 + 10 - (heroLevel % 2);
    }*/
}
