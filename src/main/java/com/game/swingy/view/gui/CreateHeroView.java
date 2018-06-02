package com.game.swingy.view.gui;

import javax.swing.*;
import java.awt.*;

public class CreateHeroView {

    private JFrame jf;
    public CreateHeroView() {

    }

    public void show() {

        jf = new JFrame("Swingy");
        JTextField nameHero = new JTextField(20);	//creating JTextField.
        jf.add(nameHero);				//adding JTextField to frame.
        jf.setLayout(new FlowLayout());
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(400, 400);
        jf.setVisible(true);
    }
}
