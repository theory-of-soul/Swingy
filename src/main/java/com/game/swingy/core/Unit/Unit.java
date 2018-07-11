package com.game.swingy.core.Unit;

import com.game.swingy.core.Map.EnumUnitTypeField;

public class Unit {

    protected EnumUnitTypeField kindOfUnit;
    protected String name;
    protected String heroClass;
    protected int level;
    protected int attack;
    protected int defense;
    protected int hitPoints;
    protected Artefacts artefacts;
    protected Coordinates coordinates;

    public Unit(EnumUnitTypeField kindOfUnit,
                   String name,
                   String heroClass,
                   int level,
                   int attack,
                   int defense,
                   int hitPoints,
                   Artefacts artefacts,
                   Coordinates coordinates) {
        this.kindOfUnit = kindOfUnit;
        this.name = name;
        this.heroClass = heroClass;
        this.level = level;
        this.attack = attack;
        this.defense = defense;
        this.hitPoints = hitPoints;
        this.artefacts = artefacts;
        this.coordinates = coordinates;
    }

    public void takeDamage(int enemyAttack) {

        int damage = enemyAttack - this.defense;
        if (damage > 0)
            this.hitPoints -= damage;
    }

    public boolean isLife() {

        if (this.hitPoints <= 0)
            return false;
        return true;
    }

    public EnumUnitTypeField getKindOfUnit() {
        return kindOfUnit;
    }

    public void setKindOfUnit(EnumUnitTypeField kindOfUnit) {
        this.kindOfUnit = kindOfUnit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeroClass() {
        return heroClass;
    }

    public void setHeroClass(String heroClass) {
        this.heroClass = heroClass;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public Artefacts getArtefacts() {
        return artefacts;
    }

    public void setArtefacts(Artefacts artefacts) {
        this.artefacts = artefacts;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
}

