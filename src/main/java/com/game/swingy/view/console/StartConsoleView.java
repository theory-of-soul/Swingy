package com.game.swingy.view.console;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class StartConsoleView implements StartViewInterface {

    private JFrame jf;
    private JButton btnCreateHero;
    private JButton btnPreviouslyHero;

    public StartConsoleView() {
        this.btnCreateHero = new JButton("Create a hero2");//Creating a Button named Say Hello
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

    public JFrame getJf() {
        return jf;
    }

    public void setJf(JFrame jf) {
        this.jf = jf;
    }

    public ActionListener getBtnCreateHero() {
        return btnCreateHero;
    }

    public void setBtnCreateHero(JButton btnCreateHero) {
        this.btnCreateHero = btnCreateHero;
    }

    public ActionListener getBtnPreviouslyHero() {
        return btnPreviouslyHero;
    }

    public void setBtnPreviouslyHero(JButton btnPreviouslyHero) {
        this.btnPreviouslyHero = btnPreviouslyHero;
    }
}
