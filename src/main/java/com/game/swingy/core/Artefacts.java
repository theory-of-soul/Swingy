package com.game.swingy.core;

public class Artefacts {

    private int weapon;
    private int armor;
    private int helm;

    public Artefacts(int weapon, int armor, int helm) {
        this.weapon = weapon;
        this.armor = armor;
        this.helm = helm;
    }

    public int getWeapon() {
        return weapon;
    }

    public void setWeapon(int weapon) {
        this.weapon = weapon;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getHelm() {
        return helm;
    }

    public void setHelm(int helm) {
        this.helm = helm;
    }
}
