package com.game.swingy.controller;

import com.game.swingy.core.Hero.Hero;
import com.game.swingy.core.Map;
import com.game.swingy.core.Unit;
import com.game.swingy.view.gui.ArenaView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ArenaController {

    private int villainHealth;
    private ArenaView arenaView;
    private Unit villain;

    public ArenaController(Unit villian) {

        this.villain = villian;
        villainHealth = this.villain.getHitPoints();
        arenaView = new ArenaView();
        setTextOnVillianLable(villian);
        setTextOnHeroLable();
        initBtn();
    }

    private void initBtn() {

        arenaView.getHeroBtn().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onClickHero();
            }
        });
        arenaView.getVillianBtn().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onClickVillain();
            }
        });
    }

    private void onClickVillain() {

        int attack = Map.getMap().getObservers().get(0).getAttack() +
                Map.getMap().getObservers().get(0).getArtefacts().getWeapon();
        villain.takeDamage(attack);
        setTextOnVillianLable(villain);
        arenaView.getTurnLable().setText("Villain turn");
        arenaView.getVillianBtn().setEnabled(false);
        arenaView.getHeroBtn().setEnabled(true);
        if (!villain.isLife())
            villainDie();
    }

    private void villainDie() {

        Hero hero = (Hero)Map.getMap().getObservers().get(0);
        hero.experienceUp(this.villainHealth);
        hero.levelUp();
        if (hero.isLevel5()) {
            arenaView.showWinner();
            arenaView.exitWindow();
        }
        arenaView.showWinView();
        arenaView.closeWindow();
        Map.getMap().setHeroMove(true);
        //TODO перевести гравця на клітку ворога і видалити ворога

    }

    private void onClickHero() {

        int attack = villain.getAttack() + villain.getArtefacts().getWeapon();
        Unit hero = (Map.getMap().getObservers().get(0));
        hero.takeDamage(attack);
        setTextOnHeroLable();
        arenaView.getTurnLable().setText("Your turn");
        arenaView.getHeroBtn().setEnabled(false);
        arenaView.getVillianBtn().setEnabled(true);
        if (!hero.isLife()) {
            arenaView.showLoser();
            arenaView.exitWindow();
        }

    }

    private void setTextOnVillianLable(Unit villian) {

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

    private void setTextOnHeroLable() {

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
