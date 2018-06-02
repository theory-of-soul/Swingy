package com.game.swingy.controller;

import com.game.swingy.view.gui.CreateHeroView;
import com.game.swingy.view.gui.StartView;

public class StarterController {

    StartView startView = new StartView(this);

    public void startGame() {

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
