package com.game.swingy.core;

public class Hero {

    protected int id;//TODO як краще визначати героя та ворога
    protected String name;
    protected String heroClass;
    protected int level;
    protected int experience;
    protected int attack;
    protected int defense;
    protected int hitPoints;
    protected String artefacts;
    protected Coorditnates coorditnates;

    static private int idCounter; //для унікальності id

    public Hero(String name,
                String heroClass,
                int level,
                int experience,
                int attack,
                int defense,
                int hitPoints,
                String artefacts,
                Coorditnates coorditnates) {
        this.id = nextId();
        this.name = name;
        this.heroClass = heroClass;
        this.level = level;
        this.experience = experience;
        this.attack = attack;
        this.defense = defense;
        this.hitPoints = hitPoints;
        this.artefacts = artefacts;
        this.coorditnates = coorditnates;
    }


    private int nextId() {

        return idCounter++;
    }

    public int getId() {
        return id;
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

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
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
}
