package com.game.swingy.core.Unit.Villain;

import com.game.swingy.core.Unit.Artefacts;
import com.game.swingy.core.Unit.Coordinates;
import com.game.swingy.core.Map.EnumUnitTypeField;
import com.game.swingy.core.Unit.Unit;

public class Villain extends Unit {

    public Villain(EnumUnitTypeField kindOfUnit,
                   String name,
                   String heroClass,
                   int level,
                   int attack,
                   int defense,
                   int hitPoints,
                   Artefacts artefacts,
                   Coordinates coordinates) {
        super(kindOfUnit, name, heroClass, level, attack,
              defense, hitPoints, artefacts, coordinates);
    }

}