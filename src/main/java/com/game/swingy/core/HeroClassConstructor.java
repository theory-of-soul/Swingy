package com.game.swingy.core;

public class HeroClassConstructor {

    public void constructSamnite(Builder builder, String name) {

        builder.setName(name);
        builder.setHeroClass("Samnite");
        builder.setLevel(0);
        builder.setExperience(0);
        builder.setAttack(15);
        builder.setDefense(15);
        builder.setHitPoints(100);
        Artefacts artefacts = new Artefacts(5,5,2);
        builder.setArtefacts(artefacts);

    }

    public void constructSkissor(Builder builder, String name) {

        builder.setName(name);
        builder.setHeroClass("Skissor");
        builder.setLevel(0);
        builder.setExperience(0);
        builder.setAttack(20);
        builder.setDefense(10);
        builder.setHitPoints(100);
        Artefacts artefacts = new Artefacts(2,5,5);
        builder.setArtefacts(artefacts);

    }

    public void constructPeltasts(Builder builder, String name) {

        builder.setName(name);
        builder.setHeroClass("Peltasts");
        builder.setLevel(0);
        builder.setExperience(0);
        builder.setAttack(10);
        builder.setDefense(20);
        builder.setHitPoints(100);
        Artefacts artefacts = new Artefacts(5,2,5);
        builder.setArtefacts(artefacts);

    }
}
