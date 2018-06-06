package com.game.swingy.core.Hero;

import com.game.swingy.core.Artefacts;
import com.game.swingy.core.Builder;
import com.game.swingy.core.Coordinates;
import com.game.swingy.core.EnumUnitTypeField;

public class HeroBuilder implements Builder {

    private EnumUnitTypeField kindOfUnit;//TODO як краще визначати героя та ворога
    private String name;
    private String heroClass;
    private int level;
    private int experience;
    private int attack;
    private int defense;
    private int hitPoints;
    private Artefacts artefacts;
    private Coordinates coordinates;

    @Override
    public void setKindOfUnit(EnumUnitTypeField kindOfUnit) {
        this.kindOfUnit = kindOfUnit;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setHeroClass(String heroClass) {
        this.heroClass = heroClass;
    }

    @Override
    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public void setAttack(int attack) {
        this.attack = attack;
    }

    @Override
    public void setDefense(int defense) {
        this.defense = defense;
    }

    @Override
    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    @Override
    public void setArtefacts(Artefacts artefacts) {
        this.artefacts = artefacts;
    }

    @Override
    public void setCoordinates(Coordinates coordinates) {
//        int mapSize = Map.getMap().getMapSize();
        this.coordinates = new Coordinates(/*mapSize /*/ 2, /*mapSize /*/ 2);//TODO як визначити кординати героя якщо його ще немає, тобто ставити вручну а якщо герой готой то вираховувати з його рівня
    }

    public Hero createHero() {
        return new Hero(kindOfUnit, name, heroClass, level, experience, attack, defense, hitPoints, artefacts, coordinates);

    }
}
