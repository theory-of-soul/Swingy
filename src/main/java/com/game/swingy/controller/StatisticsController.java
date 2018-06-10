package com.game.swingy.controller;

import com.game.swingy.core.Map;
import com.game.swingy.view.gui.HeroStatisticsView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class StatisticsController {

    private HeroStatisticsView heroStatisticsView;

    public StatisticsController() {

        heroStatisticsView = new HeroStatisticsView();
        initBtnOk();
    }

    public void setHeroFields() {

        String name = Map.getMap().getObservers().get(0).getName();
        String heroClass = Map.getMap().getObservers().get(0).getHeroClass();
        int level = Map.getMap().getObservers().get(0).getLevel();
        int experience = Map.getMap().getObservers().get(0).getExperience();
        int attack = Map.getMap().getObservers().get(0).getAttack();
        int defense = Map.getMap().getObservers().get(0).getDefense();
        int hitPoints = Map.getMap().getObservers().get(0).getHitPoints();
        int weapon = Map.getMap().getObservers().get(0).getArtefacts().getWeapon();
        int armor = Map.getMap().getObservers().get(0).getArtefacts().getArmor();

        heroStatisticsView.getLabelHeroName2().setText(name);
        heroStatisticsView.getLabelHeroCass2().setText(heroClass);
        heroStatisticsView.getLabelHeroLevel2().setText(Integer.toString(level));
        heroStatisticsView.getLabelHeroExp2().setText(Integer.toString(experience));
        heroStatisticsView.getLabelAttack2().setText(Integer.toString(attack) + " + " + Integer.toString(weapon));
        heroStatisticsView.getLabelDefense2().setText(Integer.toString(defense) + " + " + Integer.toString(armor));
        heroStatisticsView.getLabelHealth2().setText(Integer.toString(hitPoints));
        heroStatisticsView.getLabelWeapon2().setText(Integer.toString(weapon));
        heroStatisticsView.getLabelArmor2().setText(Integer.toString(armor));

    }

    private void initBtnOk() {

        heroStatisticsView.getBtnOk().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onClickOk();
            }
        });
    }

    private void onClickOk() {

        WindowEvent windowEvent = new WindowEvent(heroStatisticsView.getJf(), WindowEvent.WINDOW_CLOSING);
        heroStatisticsView.getJf().dispatchEvent(windowEvent);
    }
}
