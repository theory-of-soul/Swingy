package com.game.swingy.core;

public class VillianConstructor {

    public class Villian {

        public void constructSamnite(Builder builder, String name) {

            builder.setKindOfUnit(UnitType.ENEMY);
            builder.setName(name);
            builder.setHeroClass("Enemy");
            builder.setLevel(0);
            builder.setExperience(0);
            builder.setAttack(5);
            builder.setDefense(5);
            builder.setHitPoints(40);
            Artefacts artefacts = new Artefacts(2, 2, 2);
            builder.setCoorditnates(new Coorditnates((int) (Math.random() * 5), (int) (Math.random() * 5)));
            builder.setArtefacts(artefacts);

        }
    }
}
