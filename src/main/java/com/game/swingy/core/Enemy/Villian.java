package com.game.swingy.core.Enemy;

import com.game.swingy.core.Artefacts;
import com.game.swingy.core.Coordinates;
import com.game.swingy.core.EnumUnitTypeField;
import com.game.swingy.core.Unit;

public class Villian extends Unit {

    public Villian(EnumUnitTypeField kindOfUnit,
                String name,
                String heroClass,
                int level,
                int experience,
                int attack,
                int defense,
                int hitPoints,
                Artefacts artefacts,
                Coordinates coordinates) {
        super(kindOfUnit, name, heroClass, level, experience, attack,
              defense, hitPoints, artefacts, coordinates);
    }
}