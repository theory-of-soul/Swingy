package com.game.swingy.controller;

import com.game.swingy.core.Map.Map;
import com.game.swingy.view.console.StartViewInterface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StarterController {

    private StartViewInterface startView;

    public StarterController(StartViewInterface view) {
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
        System.out.println("Отработало создание контроллера");
        CreateHeroController createHeroController = new CreateHeroController();

    }

    private void onClickPreviouslyHero(){

        System.out.println("Отработало предвудущие герои");
        if (Map.getMap().getDbMySQL().isEmptyHeroTable()) {
            Map.getMap().createPreviousHeroView();
            Map.getMap().getPreviousHeroView().initPreviousHeroView();
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
