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
        initCreateHero();
    }

    private void initCreateHero() {
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


        //Coordinates coordinates = new Coordinates(0,0);
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
        Map.getMap().register(unitBuilder.createHero());
        Map.getMap().fillListOfVillain();
        createHeroView.getJf().dispose();
    }
}
