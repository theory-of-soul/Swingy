package com.game.swingy.view.gui;

import com.game.swingy.controller.StarterController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StartView {

    private JFrame jf;

    StarterController starterController;

    public StartView(StarterController starterController) {

        this.starterController = starterController;

    }
    public void show() {

        jf = new JFrame("Swingy");		//Creating a JFrame with name MyWindow
        JButton btnCreateHero = new JButton("Create a hero");//Creating a Button named Say Hello
        btnCreateHero.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                starterController.onClickCreateHero();
            }

        });
        JButton btnPreviouslyHero = new JButton("Select a previously created hero");//Creating a Button named Say Hello
        btnPreviouslyHero.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                starterController.onClickPreviouslyHero();
            }

        });
        jf.add(btnCreateHero);             		//adding button to frame
        jf.add(btnPreviouslyHero);             		//adding button to frame
        jf.setLayout(new FlowLayout());        //setting layout using FlowLayout object
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//setting close  operation.
        jf.setSize(400, 400);            	//setting size
        jf.setVisible(true);            	//setting frame visibility
    }

}
