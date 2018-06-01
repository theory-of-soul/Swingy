package com.game.swingy.core;

import com.game.swingy.core.Heros;
public class HeroFactory {

    public Heros newHero(String name,
                         String heroClass,
                         int level,
                         int experience,
                         int attack,
                         int defense,
                         int hitPoints) {
        return new Heros(name, heroClass, level, experience, attack, defense, hitPoints);

    }
}
