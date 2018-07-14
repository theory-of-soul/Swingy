package com.game.swingy.view.gui;

import com.game.swingy.view.StartView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class StartGuiView implements StartView {

    private JFrame jf;
    private JButton btnCreateHero;
    private JButton btnPreviouslyHero;

    public StartGuiView() {
        this.btnCreateHero = new JButton("Create a hero");//Creating a Button named Say Hello
        this.btnPreviouslyHero = new JButton("Select a previously created hero");//Creating a Button named Say Hello

        jf = new JFrame("Swingy");		//Creating a JFrame with name MyWindow
        jf.add(btnCreateHero);             		//adding button to frame
        jf.add(btnPreviouslyHero);             		//adding button to frame
        jf.setLayout(new FlowLayout());        //setting layout using FlowLayout object
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//setting close  operation.
        jf.setSize(400, 400);            	//setting size
        jf.setVisible(true);            	//setting frame visibility
        jf.setLocationRelativeTo(null);
        jf.pack();
    }

    @Override
    public void createHero(ActionListener action) {
        this.btnCreateHero.addActionListener(action);
    }

    @Override
    public void showPreviouslyHeroes(ActionListener action) {
        this.btnPreviouslyHero.addActionListener(action);
    }
}
