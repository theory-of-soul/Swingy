package com.game.swingy.core.Enemy;

import com.game.swingy.core.Artefacts;
import com.game.swingy.core.Builder;
import com.game.swingy.core.Coordinates;
import com.game.swingy.core.EnumUnitTypeField;

public class VillianConstructor {

    public class Villian {

        public void constructSamnite(Builder builder, String name) {

            builder.setKindOfUnit(EnumUnitTypeField.ENEMY);
            builder.setName(name);
            builder.setHeroClass("Enemy");
            builder.setLevel(0);
            builder.setExperience(0);
            builder.setAttack(5);
            builder.setDefense(5);
            builder.setHitPoints(40);
            Artefacts artefacts = new Artefacts(2, 2, 2);
            builder.setCoordinates(new Coordinates(-1, -1));
            builder.setArtefacts(artefacts);

        }
    }
}
