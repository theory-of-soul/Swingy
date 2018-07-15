package com.game.swingy.core.Unit;

import com.game.swingy.core.Map.UnitTypeFieldEnum;

public class UnitConstructor {

    public void constructSamnite(Builder builder, String name) {

        builder.setKindOfUnit(UnitTypeFieldEnum.HERO);
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

        builder.setKindOfUnit(UnitTypeFieldEnum.HERO);
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

        builder.setKindOfUnit(UnitTypeFieldEnum.HERO);
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

    public void constructVillian0(Builder builder, String name) {

        builder.setKindOfUnit(UnitTypeFieldEnum.ENEMY);
        builder.setName(name);
        builder.setHeroClass("Villain");
        builder.setLevel(0);
        builder.setAttack(5);
        builder.setDefense(5);
        builder.setHitPoints(40);
        Artefacts artefacts = new Artefacts(20, 2, 2);
        builder.setCoordinates(new Coordinates(-1, -1));
        builder.setArtefacts(artefacts);

    }

    public void constructVillian1(Builder builder, String name) {

        builder.setKindOfUnit(UnitTypeFieldEnum.ENEMY);
        builder.setName(name);
        builder.setHeroClass("Villain");
        builder.setLevel(1);
        builder.setAttack(10);
        builder.setDefense(10);
        builder.setHitPoints(50);
        Artefacts artefacts = new Artefacts(25, 5, 5);
        builder.setCoordinates(new Coordinates(-1, -1));
        builder.setArtefacts(artefacts);

    }

    public void constructVillian2(Builder builder, String name) {

        builder.setKindOfUnit(UnitTypeFieldEnum.ENEMY);
        builder.setName(name);
        builder.setHeroClass("Villain");
        builder.setLevel(2);
        builder.setAttack(15);
        builder.setDefense(15);
        builder.setHitPoints(55);
        Artefacts artefacts = new Artefacts(30, 10, 10);
        builder.setCoordinates(new Coordinates(-1, -1));
        builder.setArtefacts(artefacts);

    }

    public void constructVillian3(Builder builder, String name) {

        builder.setKindOfUnit(UnitTypeFieldEnum.ENEMY);
        builder.setName(name);
        builder.setHeroClass("Villain");
        builder.setLevel(3);
        builder.setAttack(20);
        builder.setDefense(20);
        builder.setHitPoints(60);
        Artefacts artefacts = new Artefacts(35, 15, 15);
        builder.setCoordinates(new Coordinates(-1, -1));
        builder.setArtefacts(artefacts);

    }

    public void constructVillian4(Builder builder, String name) {

        builder.setKindOfUnit(UnitTypeFieldEnum.ENEMY);
        builder.setName(name);
        builder.setHeroClass("Villain");
        builder.setLevel(4);
        builder.setAttack(30);
        builder.setDefense(30);
        builder.setHitPoints(80);
        Artefacts artefacts = new Artefacts(40, 25, 25);
        builder.setCoordinates(new Coordinates(-1, -1));
        builder.setArtefacts(artefacts);

    }
}
