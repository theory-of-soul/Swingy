package com.game.swingy.controller;

import com.game.swingy.core.Map.Map;
import com.game.swingy.core.Map.ModeEnum;
import com.game.swingy.view.StartView;
import com.game.swingy.view.console.StartConsoleView;
import com.game.swingy.view.gui.StartGuiView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StarterController {

    private StartView startView;

    public StarterController() {
        if (Map.getMap().getMode() == ModeEnum.GUI)
            this.startView = new StartGuiView();
        else
            this.startView = new StartConsoleView();
        initGame();
    }

    public void initGame() {
        startView.createHero(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onClickCreateHero();
            }
        });

        startView.showPreviouslyHeroes(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onClickPreviouslyHero();
            }
        });
    }

    private void onClickCreateHero(){
        System.out.println("Отработало создание контроллера");
        CreateHeroController createHeroController = new CreateHeroController();

    }

    private void onClickPreviouslyHero(){

        System.out.println("Отработало предвудущие герои");
        if (Map.getMap().getDbMySQL().isEmptyHeroTable()) {
            PreviousHeroController previousHeroController = new
                    PreviousHeroController();
        }
        else {
            JOptionPane.showMessageDialog(null,
                    "At this time, you don't have saving hero");
        }
        //bc.setVisible(true);
        //bc.createAndShowGUI();
    }

    //TODO close starterView
}
