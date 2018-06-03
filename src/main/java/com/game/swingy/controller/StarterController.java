package com.game.swingy.controller;

import com.game.swingy.view.gui.CreateHeroView;
import com.game.swingy.view.gui.StartView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StarterController {

    private StartView startView;

    public StarterController(StartView view) {
        this.startView = view;
    }

    public void initGame() {
        startView.getBtnCreateHero().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onClickCreateHero();
            }
        });
        startView.getBtnPreviouslyHero().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onClickPreviouslyHero();
            }
        });
    }

    private void onClickCreateHero(){

        CreateHeroView createHeroView = new CreateHeroView();
        System.out.println("Отработало создание контроллера");
        CreateHeroController createHeroController = new CreateHeroController(createHeroView);
        createHeroController.initCreateHero();

    }

    private void onClickPreviouslyHero(){

        System.out.println("Отработало предвудущие герои");
    }
}
