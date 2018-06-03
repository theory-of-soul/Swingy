package com.game.swingy;

import com.game.swingy.controller.StarterController;
import com.game.swingy.view.gui.StartView;

public class Game {

    public static void main(String[] args) {

        StartView startView = new StartView();
        StarterController starterController = new StarterController(startView);
        starterController.initGame();
    }
}
