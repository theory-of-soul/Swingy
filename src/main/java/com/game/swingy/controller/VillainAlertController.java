package com.game.swingy.controller;

import com.game.swingy.core.Unit;
import com.game.swingy.view.gui.VillianAllertView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class VillainAlertController {

    private VillianAllertView villianAllertView;
    private MapController mapController;
    private Unit villain;

    public VillainAlertController(Unit villian, MapController mapController) {

        this.villain = villian;
        this.mapController = mapController;
        villianAllertView = new VillianAllertView();
        setTextOnBtnLabel(villian);
        initBtn(villian);
    }

    private void initBtn(Unit villian) {

        villianAllertView.getRunBtn().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onClickRun();
            }
        });
        villianAllertView.getFightBtn().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onClickFight();
            }
        });
    }

    private void onClickRun() {

        if (villianAllertView.showRunAllert() == 0)
            onClickRunYes();
        else
            System.out.println("no");
    }

    private void onClickRunYes() {

        Random random = new Random();
        if (random.nextBoolean()) {
            System.out.println("true");
            villianAllertView.showDisLucky();
            villianAllertView.closeWindow();
            ArenaController arenaController = new ArenaController(this.villain, this.mapController);

        }
        else {
            System.out.println("false");
            villianAllertView.showLucky();
            villianAllertView.closeWindow();
        }
    }

    private void onClickFight() {

        System.out.println("Fight");
        if (villianAllertView.showFightAllert() == 0) {
            System.out.println("yes");
            ArenaController arenaController = new ArenaController(this.villain, this.mapController);
            villianAllertView.closeWindow();
        }
    }

    private void setTextOnBtnLabel(Unit villian) {

        int level = villian.getLevel();
        int attack = villian.getAttack();
        int defense = villian.getDefense();
        int weapon = villian.getArtefacts().getWeapon();
        int armor = villian.getArtefacts().getArmor();
        int health = villian.getHitPoints();

        villianAllertView.getLevellabel2().setText(Integer.toString(level));
        villianAllertView.getAttackLabel2().setText(Integer.toString(attack) +
                " + " + Integer.toString(weapon));
        villianAllertView.getDefenseLabel2().setText(Integer.toString(defense) +
                " + " + Integer.toString(armor));
        villianAllertView.getWeaponLabel2().setText(Integer.toString(weapon));
        villianAllertView.getArmorLabel2().setText(Integer.toString(armor));
        villianAllertView.getHealthLabel2().setText(Integer.toString(health));

    }
}
