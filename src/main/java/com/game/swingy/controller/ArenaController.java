package com.game.swingy.controller;

import com.game.swingy.core.Artefacts;
import com.game.swingy.core.Hero.Hero;
import com.game.swingy.core.Map;
import com.game.swingy.core.Unit;
import com.game.swingy.view.gui.ArenaView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class ArenaController {

    private int villainHealth;
    private ArenaView arenaView;
    private MapController mapController;
    private Unit villain;

    public ArenaController(Unit villian, MapController mapController) {

        this.villain = villian;
        this.mapController = mapController;
        villainHealth = this.villain.getHitPoints();
        arenaView = new ArenaView();
        setTextOnVillainLable(villian);
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
        setTextOnVillainLable(villain);
        arenaView.getTurnLable().setText("Villain turn");
        arenaView.getVillianBtn().setEnabled(false);
        arenaView.getHeroBtn().setEnabled(true);
        if (!villain.isLife())
            villainDie();
    }

    private void villainDie() {

        Hero hero = (Hero)Map.getMap().getObservers().get(0);
        Random random = new Random();
        hero.experienceUp(this.villainHealth);
        hero.levelUp();
        if (hero.isLevel5()) {
            arenaView.showWinner();
            arenaView.exitWindow();
        }
        arenaView.showWinVillainView();
        arenaView.closeWindow();
        mapController.heroKilledVillain(this.villain);
        if (random.nextInt(2) == 0)
            setArtefacts();
        mapController.getMapViewFrame().setVisible(true);
    }

    private void setArtefacts() {

        Artefacts artefacts;
        Hero hero = (Hero)Map.getMap().getObservers().get(0);
        switch (arenaView.showArtefacts()) {
            case 0:
                System.out.println("weapon");
                artefacts = new Artefacts(villain.getArtefacts().getWeapon(),
                        hero.getArtefacts().getArmor(), hero.getArtefacts().getHelm());
                hero.setArtefacts(artefacts);
                break;
            case 1:
                System.out.println("weapon");
                artefacts = new Artefacts(hero.getArtefacts().getWeapon(),
                        villain.getArtefacts().getArmor(), hero.getArtefacts().getHelm());
                hero.setArtefacts(artefacts);
                break;
            case 2:
                System.out.println("weapon");
                artefacts = new Artefacts(hero.getArtefacts().getWeapon(),
                        hero.getArtefacts().getArmor(), villain.getArtefacts().getHelm());
                hero.setHitPoints(hero.getHitPoints() + villain.getArtefacts().getHelm());
                hero.setArtefacts(artefacts);
                break;
        }
    }

    private void onClickHero() {

        int attack = villain.getAttack() + villain.getArtefacts().getWeapon();
        Unit hero = (Map.getMap().getObservers().get(0));

        Random random = new Random();
        if (random.nextInt(5) == 0)
            arenaView.showMissAttack();
        else
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

    private void setTextOnVillainLable(Unit villain) {

        int level = villain.getLevel();
        int attack = villain.getAttack();
        int defense = villain.getDefense();
        int weapon = villain.getArtefacts().getWeapon();
        int armor = villain.getArtefacts().getArmor();
        int health = villain.getHitPoints();

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

        Hero hero = (Hero)Map.getMap().getObservers().get(0);
        String name = hero.getName();
        String heroClass = hero.getHeroClass();
        int level = hero.getLevel();
        int experience = hero.getExperience();
        int attack = hero.getAttack();
        int defense = hero.getDefense();
        int hitPoints = hero.getHitPoints();
        int weapon = hero.getArtefacts().getWeapon();
        int armor = hero.getArtefacts().getArmor();

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
