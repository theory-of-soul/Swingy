package com.game.swingy.core;

public interface HeroActions {

    public abstract void levelUp(int hitPoint, int experience);
    public abstract void experienceUp(int experience);
    public abstract void attack(int enemyAttack);
    public abstract void move(Direction direction);
}
