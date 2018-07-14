package com.game.swingy;

import com.game.swingy.controller.StarterController;
import com.game.swingy.core.Map.Map;
import com.game.swingy.core.Map.ModeEnum;

public class Game {

    public static void main(String[] args) {

        if (args.length == 0 || args.length > 1) {
            System.out.println("Usage: [console | gui]");
            System.exit(2);
        }
        switch (args[0]) {
            case ("console"):
                Map.getMap().setMode(ModeEnum.CONSOLE);
                break;
            case ("gui") :
                Map.getMap().setMode(ModeEnum.GUI);
                break;
            default:
                System.out.println("Usage: [console | gui]");
                System.exit(2);
        }

        StarterController starterController = new StarterController();
    }


    //starterController.initGame();
}