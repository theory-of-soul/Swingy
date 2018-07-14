package com.game.swingy;

import com.game.swingy.controller.StarterController;
import com.game.swingy.view.console.StartConsoleView;
import com.game.swingy.view.console.StartViewInterface;
import com.game.swingy.view.gui.StartGuiView;

public class Game {

    private static StartViewInterface startView;

    public static void main(String[] args) {

        String gameMode = args[0]; // gui and console

        if (gameMode.equals("gui")) {
            startView = new StartGuiView();
        } else {
            startView = new StartConsoleView();
        }

        StarterController starterController = new StarterController(startView);
        starterController.initGame();
    }
}