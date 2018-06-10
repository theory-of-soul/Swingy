package com.game.swingy.controller;

import com.game.swingy.core.Map;
import com.game.swingy.core.Unit;
import com.game.swingy.view.gui.ArenaView;

public class ArenaController {

    private ArenaView arenaView;

    public ArenaController(Unit villian) {

        arenaView = new ArenaView();
        setTextOnVillianBtn(villian);
        setTextOnHeroBtn();
    }

    private void setTextOnVillianBtn(Unit villian) {

        int level = villian.getLevel();
        int attack = villian.getAttack();
        int defense = villian.getDefense();
        int weapon = villian.getArtefacts().getWeapon();
        int armor = villian.getArtefacts().getArmor();
        int health = villian.getHitPoints();

        arenaView.getLevellabel2().setText(Integer.toString(level));
        arenaView.getAttackLabel2().setText(Integer.toString(attack) +
                " + " + Integer.toString(weapon));
        arenaView.getDefenseLabel2().setText(Integer.toString(defense) +
                " + " + Integer.toString(armor));
        arenaView.getWeaponLabel2().setText(Integer.toString(weapon));
        arenaView.getArmorLabel2().setText(Integer.toString(armor));
        arenaView.getHealthLabel2().setText(Integer.toString(health));
    }

    private void setTextOnHeroBtn() {

        String name = Map.getMap().getObservers().get(0).getName();
        String heroClass = Map.getMap().getObservers().get(0).getHeroClass();
        int level = Map.getMap().getObservers().get(0).getLevel();
        int experience = Map.getMap().getObservers().get(0).getExperience();
        int attack = Map.getMap().getObservers().get(0).getAttack();
        int defense = Map.getMap().getObservers().get(0).getDefense();
        int hitPoints = Map.getMap().getObservers().get(0).getHitPoints();
        int weapon = Map.getMap().getObservers().get(0).getArtefacts().getWeapon();
        int armor = Map.getMap().getObservers().get(0).getArtefacts().getArmor();

        arenaView.getLabelHeroName2().setText(name);
        arenaView.getLabelHeroCass2().setText(heroClass);
        arenaView.getLabelHeroLevel2().setText(Integer.toString(level));
        arenaView.getLabelHeroExp2().setText(Integer.toString(experience));
        arenaView.getLabelAttack2().setText(Integer.toString(attack) + " + " + Integer.toString(weapon));
        arenaView.getLabelDefense2().setText(Integer.toString(defense) + " + " + Integer.toString(armor));
        arenaView.getLabelHealth2().setText(Integer.toString(hitPoints));
        arenaView.getLabelWeapon2().setText(Integer.toString(weapon));
        arenaView.getLabelArmor2().setText(Integer.toString(armor));

    }
}
