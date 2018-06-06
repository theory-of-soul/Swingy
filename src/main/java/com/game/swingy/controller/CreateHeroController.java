package com.game.swingy.controller;

import com.game.swingy.core.*;
import com.game.swingy.core.Enemy.VillianBuilder;
import com.game.swingy.core.Hero.HeroBuilder;
import com.game.swingy.core.Hero.HeroClassConstructor;
import com.game.swingy.view.gui.CreateHeroView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class CreateHeroController {

    private CreateHeroView createHeroView;

    public CreateHeroController(CreateHeroView createHeroView) {
        this.createHeroView = createHeroView;
    }

    public void initCreateHero() {
        createHeroView.getBtnCreate().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onClickCreate();
            }
        });
    }

    private void onClickCreate() {

        System.out.println("Отработало создание героя");
        HeroClassConstructor heroClassConstructor = new HeroClassConstructor();
        HeroBuilder heroBuilder = new HeroBuilder();
        VillianBuilder villianBuilder = new VillianBuilder();



        String nameHero;
        String selectedHeroClass;


        Coordinates coordinates = new Coordinates(0,0);
        nameHero = createHeroView.getNameHero().getText();
        selectedHeroClass = (String) createHeroView.getHeroClassList().getSelectedItem();

        switch (selectedHeroClass) {

            case ("Samnite") :
                heroClassConstructor.constructSamnite(heroBuilder, nameHero);
                break;
            case ("Skissor") :
                heroClassConstructor.constructSkissor(heroBuilder, nameHero);
                break;
            case ("Peltasts") :
                heroClassConstructor.constructPeltasts(heroBuilder, nameHero);
                break;

        }
        Map.getMap().register(heroBuilder.createHero());//TODO записувати героїв в БД, або в масив а потім в БД
        for (int i = 0; i < 12; i++) {
            Map.getMap().register(villianBuilder.createEnemy());
        }
        //System.out.println(tyty.toString());
        //System.out.println(tyty.getHeroClass());
        WindowEvent windowEvent = new WindowEvent(createHeroView.getJf(), WindowEvent.WINDOW_CLOSING);
        createHeroView.getJf().dispatchEvent(windowEvent);
        MapController mapController = new MapController(Map.getMap().getObservers());//TODO правильно передавати рівень героя;
        mapController.deAndActivatedbtnUnits();
        mapController.setRendomCoordinats();
        System.out.println("x=" + Map.getMap().getObservers().get(1).getName());
        System.out.println("x=" + Map.getMap().getObservers().get(2).getName());
    }
}
