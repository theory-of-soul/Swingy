package com.game.swingy.controller;

import com.game.swingy.core.Map.Map;
import com.game.swingy.core.Unit.Coordinates;
import com.game.swingy.core.Unit.UnitBuilder;
import com.game.swingy.core.Unit.UnitConstructor;
import com.game.swingy.view.gui.CreateHeroView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        UnitConstructor unitConstructor = new UnitConstructor();
        UnitBuilder unitBuilder = new UnitBuilder();

        String nameHero;
        String selectedHeroClass;


        Coordinates coordinates = new Coordinates(0,0);
        nameHero = createHeroView.getNameHero().getText();
        selectedHeroClass = (String) createHeroView.getHeroClassList().getSelectedItem();

        switch (selectedHeroClass) {

            case ("Samnite") :
                unitConstructor.constructSamnite(unitBuilder, nameHero);
                break;
            case ("Skissor") :
                unitConstructor.constructSkissor(unitBuilder, nameHero);
                break;
            case ("Peltasts") :
                unitConstructor.constructPeltasts(unitBuilder, nameHero);
                break;
        }
        Map.getMap().register(unitBuilder.createHero());//TODO записувати героїв в БД, або в масив а потім в БД
        /*for (int i = 0; i < 12; i++) {//TODO правильно визначати кількість ворогів
            unitConstructor.constructVillian(unitBuilder, Integer.toString(i));
            Map.getMap().register(unitBuilder.createVillian());
        }*/
        Map.getMap().fillListOfVillain();
        createHeroView.closeWindow();
        //MapController mapController = new MapController(Map.getMap().getObservers());//TODO правильно передавати рівень героя;
        /*mapController.deAndActivatedbtnUnits();
        mapController.setRandomCoordinates();
        mapController.initMoveHero();*/

    }
}
