package com.game.swingy.controller;

import com.game.swingy.core.Coorditnates;
import com.game.swingy.core.Hero;
import com.game.swingy.core.HeroBuilder;
import com.game.swingy.core.HeroClassConstructor;
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


        String nameHero;


        Coorditnates coorditnates = new Coorditnates(0,0);
        heroBuilder.setName(createHeroView.getNameHero().getText());
        String selectedHeroClass = (String) createHeroView.getHeroClassList().getSelectedItem();
        heroBuilder.setHeroClass(selectedHeroClass);
        Hero tyty = heroBuilder.createHero();//TODO записувати героїв в БД, або в масив а потім в БД
        System.out.println(tyty.getName());
        System.out.println(tyty.getHeroClass());
        WindowEvent windowEvent = new WindowEvent(createHeroView.getJf(), WindowEvent.WINDOW_CLOSING);
        createHeroView.getJf().dispatchEvent(windowEvent);
    }
}
