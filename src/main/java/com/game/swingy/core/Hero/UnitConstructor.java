package com.game.swingy.core.Hero;

import com.game.swingy.core.Artefacts;
import com.game.swingy.core.Builder;
import com.game.swingy.core.Coordinates;
import com.game.swingy.core.EnumUnitTypeField;

public class UnitConstructor {

    public void constructSamnite(Builder builder, String name) {

        builder.setKindOfUnit(EnumUnitTypeField.HERO);
        builder.setName(name);
        builder.setHeroClass("Samnite");
        builder.setLevel(0);
        builder.setExperience(0);
        builder.setAttack(15);
        builder.setDefense(15);
        builder.setHitPoints(100);
        Artefacts artefacts = new Artefacts(5,5,2);
        builder.setCoordinates(new Coordinates(2,2));
        builder.setArtefacts(artefacts);

    }

    public void constructSkissor(Builder builder, String name) {

        builder.setKindOfUnit(EnumUnitTypeField.HERO);
        builder.setName(name);
        builder.setHeroClass("Skissor");
        builder.setLevel(0);
        builder.setExperience(0);
        builder.setAttack(20);
        builder.setDefense(10);
        builder.setHitPoints(100);
        Artefacts artefacts = new Artefacts(2,5,5);
        builder.setCoordinates(new Coordinates(2,2));
        builder.setArtefacts(artefacts);

    }

    public void constructPeltasts(Builder builder, String name) {

        builder.setKindOfUnit(EnumUnitTypeField.HERO);
        builder.setName(name);
        builder.setHeroClass("Peltasts");
        builder.setLevel(0);
        builder.setExperience(0);
        builder.setAttack(10);
        builder.setDefense(20);
        builder.setHitPoints(100);
        Artefacts artefacts = new Artefacts(5,2,5);
        builder.setCoordinates(new Coordinates(2,2));
        builder.setArtefacts(artefacts);
    }

    public void constructVillian(Builder builder, String name) {

        builder.setKindOfUnit(EnumUnitTypeField.ENEMY);
        builder.setName(name);
        builder.setHeroClass("Enemy");
        builder.setLevel(0);
        builder.setExperience(0);
        builder.setAttack(5);
        builder.setDefense(5);
        builder.setHitPoints(40);
        Artefacts artefacts = new Artefacts(20, 2, 2);
        builder.setCoordinates(new Coordinates(-1, -1));
        builder.setArtefacts(artefacts);

    }
}
