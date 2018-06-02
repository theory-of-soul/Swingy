package com.game.swingy.controller;

import com.game.swingy.view.gui.CreateHeroView;
import com.game.swingy.view.gui.StartView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StarterController {

    StartView startView = new StartView();

    public void startGame() {

        startView.getBtnCreateHero().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onClickCreateHero();
            }
        });
        startView.show();
    }

    public void onClickCreateHero(){

        System.out.println("Отработало создание героя");
        CreateHeroView createHeroView = new CreateHeroView();
        createHeroView.show();
    }

    public void onClickPreviouslyHero(){

        System.out.println("Отработало предвудущие герои");
    }
}
