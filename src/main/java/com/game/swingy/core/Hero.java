package com.game.swingy.core;

public class Hero implements HeroActions{

    protected int id;//TODO як краще визначати героя та ворога
    protected String name;
    protected String heroClass;
    protected int level;
    protected int experience;
    protected int attack;
    protected int defense;
    protected int hitPoints;
    protected Artefacts artefacts;
    protected Coorditnates coorditnates;

    static private int idCounter; //для унікальності id

    public Hero(String name,
                String heroClass,
                int level,
                int experience,
                int attack,
                int defense,
                int hitPoints,
                Artefacts artefacts,
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

    @Override
    public void levelUp(int hitPoint, int experience) {

        if (experience >= 1000 && experience < 2450)
            this.level = 2;
        else if (experience >= 2450)
            this.level = 3;
    }

    @Override
    public void experienceUp(int experience) {

        this.experience += experience;
    }

    @Override
    public void attack(int enemyAttack) {

        int damage = enemyAttack - this.defense;
        if (damage > 0)
            this.hitPoints -= damage;
    }

    @Override
    public void move(Direction direction) {

        int x = this.coorditnates.getX();
        int y = this.coorditnates.getY();
        switch (direction) {
            case EAST:
                this.coorditnates = new Coorditnates(x + 1, y);
                break;
            case WEST:
                this.coorditnates = new Coorditnates(x - 1, y);
                break;
            case NORTH:
                this.coorditnates = new Coorditnates(x, y - 1);
                break;
            case SOUTH:
                this.coorditnates = new Coorditnates(x, y + 1);
                break;
        }


        System.out.println("d");
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
