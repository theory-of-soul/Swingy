package com.game.swingy.core.Hero;

import com.game.swingy.core.EnumDirection;

public interface HeroActions {

    //public abstract void levelUp(int hitPoint, int experience);
    //public abstract void experienceUp(int experience);
    public abstract void getAttack(int enemyAttack);
    public abstract void move(EnumDirection enumDirection);
}

