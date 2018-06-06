package com.game.swingy.core;

public class Villian {

    protected UnitType kindOfUnit;//TODO як краще визначати героя та ворога
    protected String name;
    protected String heroClass;
    protected int level;
    protected int experience;
    protected int attack;
    protected int defense;
    protected int hitPoints;
    protected Artefacts artefacts;
    protected Coorditnates coorditnates;

    public Villian(UnitType kindOfUnit,
                String name,
                String heroClass,
                int level,
                int experience,
                int attack,
                int defense,
                int hitPoints,
                Artefacts artefacts,
                Coorditnates coorditnates) {
        this.kindOfUnit = kindOfUnit;
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
}