package com.game.swingy.core;

public class HeroBuilder implements Builder {

    private int id;//TODO як краще визначати героя та ворога
    private String name;
    private String heroClass;
    private int level;
    private int experience;
    private int attack;
    private int defense;
    private int hitPoints;
    private String artefacts;
    private Coorditnates coorditnates;

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
    public void setArtefacts(String artefacts) {
        this.artefacts = artefacts;
    }

    @Override
    public void setCoorditnates(Coorditnates coorditnates) {
        this.coorditnates = coorditnates;
    }

    public Hero createHero(String name,
                           String heroClass,
                           int level,
                           int experience,
                           int attack,
                           int defense,
                           int hitPoints,
                           String artefacts,
                           Coorditnates coorditnates) {
        return new Hero(name, heroClass, level, experience, attack, defense, hitPoints, artefacts, coorditnates);

    }
}
