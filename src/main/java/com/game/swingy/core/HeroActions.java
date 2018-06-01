package com.game.swingy.core;

public interface HeroActions {

    public abstract void levelUp(int hitPoint, int experience);
    public abstract void experienceUp();
    public abstract void attack();
    public abstract void defense();
    public abstract void hitPointsDecrease();
    public abstract void move();
}
