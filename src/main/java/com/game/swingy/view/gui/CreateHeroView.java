package com.game.swingy.view.gui;

import javax.swing.*;
import java.awt.*;

public class CreateHeroView {

    private JFrame jf;
    private JLabel labelName;
    private JLabel labelHeroType;
    private JPanel panel;
    private Container content;
    private JTextField nameHero;
    private JButton btnCreate;
    private String[] heroClass;
    private JComboBox<String> heroClassList;

    public CreateHeroView() {

        heroClass = new String[] {"Samnite", "Skissor", "Peltasts"};
        btnCreate = new JButton("Create the hero");
        jf = new JFrame("Swingy");
        content = jf.getContentPane();
        panel = new JPanel(new GridLayout(2,2));
        panel.setSize(100,50);
        labelName = new JLabel("Name: ");
        nameHero = new JTextField();
        heroClassList = new JComboBox<>(heroClass);
        labelHeroType = new JLabel("Type of hero:");
        labelName.setLabelFor(nameHero);
        labelHeroType.setLabelFor(heroClassList);

        panel.add(labelName);
        panel.add(nameHero);
        panel.add(labelHeroType);
        panel.add(heroClassList);

        content.add(panel, BorderLayout.NORTH);
        content.add(btnCreate, BorderLayout.SOUTH);
        jf.setSize(450, 105);
        jf.setVisible(true);
        jf.setLocationRelativeTo(null);

    }

    public JButton getBtnCreate() {
        return btnCreate;
    }

    public JTextField getNameHero() {
        return nameHero;
    }

    public JComboBox<String> getHeroClassList() {
        return heroClassList;
    }

    public JFrame getJf() {
        return jf;
    }
}
