package com.game.swingy.core;

public class HeroBuilder implements Builder {

    private UnitType kindOfUnit;//TODO як краще визначати героя та ворога
    private String name;
    private String heroClass;
    private int level;
    private int experience;
    private int attack;
    private int defense;
    private int hitPoints;
    private Artefacts artefacts;
    private Coorditnates coorditnates;

    @Override
    public void setKindOfUnit(UnitType kindOfUnit) {
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
    public void setCoorditnates(Coorditnates coorditnates) {
//        int mapSize = Map.getMap().getMapSize();
        this.coorditnates = new Coorditnates(/*mapSize /*/ 2, /*mapSize /*/ 2);//TODO як визначити кординати героя якщо його ще немає, тобто ставити вручну а якщо герой готой то вираховувати з його рівня
    }

    public Hero createHero() {
        return new Hero(kindOfUnit, name, heroClass, level, experience, attack, defense, hitPoints, artefacts, coorditnates);

    }
    public Hero createEnemy() {
        return new Hero(kindOfUnit, name, heroClass, level, experience, attack, defense, hitPoints, artefacts, coorditnates);

    }


}
