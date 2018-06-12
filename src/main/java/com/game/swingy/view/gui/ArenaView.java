package com.game.swingy.view.gui;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.WindowEvent;

public class ArenaView {

    private JFrame jf;
    private JFrame allertFrame;
    private JLabel lableVillian;
    private JLabel levellabel1;
    private JLabel levellabel2;
    private JLabel attackLabel1;
    private JLabel attackLabel2;
    private JLabel defenseLabel1;
    private JLabel defenseLabel2;
    private JLabel artefactsLabel;
    private JLabel weaponLabel1;
    private JLabel weaponLabel2;
    private JLabel armorLabel1;
    private JLabel armorLabel2;
    private JLabel healthLabel1;
    private JLabel healthLabel2;
    private JLabel labelYourHero;
    private JLabel labelHeroName1;
    private JLabel labelHeroName2;
    private JLabel labelHeroCass1;
    private JLabel labelHeroCass2;
    private JLabel labelHeroLevel1;
    private JLabel labelHeroLevel2;
    private JLabel labelHeroExp1;
    private JLabel labelHeroExp2;
    private JLabel labelAttack1;
    private JLabel labelAttack2;
    private JLabel labelDefense1;
    private JLabel labelDefense2;
    private JLabel labelArtefacts;
    private JLabel labelWeapon1;
    private JLabel labelWeapon2;
    private JLabel labelArmor1;
    private JLabel labelArmor2;
    private JLabel labelHealth1;
    private JLabel labelHealth2;
    private JLabel turnLable;
    private JPanel panelHero;
    private JPanel panelMain;
    private JPanel panelVillian;
    private JButton heroBtn;
    private JButton villianBtn;

    public ArenaView() {

        createTools();
    }

    private void createTools() {

        jf = new JFrame("Swingy Arena");
        allertFrame = new JFrame();
        createHeroTools();
        createVillianTools();
        turnLable = new JLabel("Your turn");
        turnLable.setForeground(Color.RED);
        panelMain = new JPanel(new GridBagLayout());
        setHeroOnPanelHero();
        setVillianOnVillianPanel();
        setAllOnMainPanel();
        jf.setLayout(new FlowLayout());
        jf.add(panelMain);
        jf.setSize(580, 380);
        jf.setVisible(true);
        jf.setLocationRelativeTo(null);
    }

    private void setAllOnMainPanel() {

        panelMain.add(labelYourHero, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(5,5,5,5),
                0,0));
        panelMain.add(turnLable, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(5,5,5,5),
                0,0));
        panelMain.add(lableVillian, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(5,5,5,5),
                0,0));
        panelMain.add(heroBtn, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(5,5,5,5),
                0,0));
        panelMain.add(villianBtn, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(5,5,5,5),
                0,0));
        panelMain.add(panelHero, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(5,5,5,5),
                0,0));
        panelMain.add(panelVillian, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(5,5,5,5),
                0,0));
    }

    private void setVillianOnVillianPanel() {

        panelVillian.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
        panelVillian.add(levellabel1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(5,5,5,5),
                0,0));
        panelVillian.add(levellabel2, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(5,5,5,5),
                0,0));
        panelVillian.add(attackLabel1, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(5,5,5,5),
                0,0));
        panelVillian.add(attackLabel2, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(5,5,5,5),
                0,0));
        panelVillian.add(defenseLabel1, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(5,5,5,5),
                0,0));
        panelVillian.add(defenseLabel2, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(5,5,5,5),
                0,0));
        panelVillian.add(artefactsLabel, new GridBagConstraints(0, 3, 2, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(5,5,5,5),
                0,0));
        artefactsLabel.setHorizontalAlignment(JLabel.CENTER);
        panelVillian.add(weaponLabel1, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(5,5,5,5),
                0,0));
        panelVillian.add(weaponLabel2, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(5,5,5,5),
                0,0));
        panelVillian.add(armorLabel1, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(5,5,5,5),
                0,0));
        panelVillian.add(armorLabel2, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(5,5,5,5),
                0,0));
        panelVillian.add(healthLabel1, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(5,5,5,5),
                0,0));
        panelVillian.add(healthLabel2, new GridBagConstraints(1, 6, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(5,5,5,5),
                0,0));
    }

    private void setHeroOnPanelHero() {

        panelHero.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
        panelHero.add(labelYourHero, new GridBagConstraints(0, 0, 2, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.BOTH, new Insets(5,5,5,5),
                0,0));
        panelHero.add(labelHeroName1, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(5,5,5,5),
                0,0));
        panelHero.add(labelHeroName2, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(5,5,5,5),
                0,0));
        panelHero.add(labelHeroCass1, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(5,5,5,5),
                0,0));
        panelHero.add(labelHeroCass2, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(5,5,5,5),
                0,0));
        panelHero.add(labelHeroLevel1, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(5,5,5,5),
                0,0));
        panelHero.add(labelHeroLevel2, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(5,5,5,5),
                0,0));
        panelHero.add(labelHeroExp1, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(5,5,5,5),
                0,0));
        panelHero.add(labelHeroExp2, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(5,5,5,5),
                0,0));
        panelHero.add(labelHealth1, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(5,5,5,5),
                0,0));
        panelHero.add(labelHealth2, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(5,5,5,5),
                0,0));
        panelHero.add(labelAttack1, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(5,5,5,5),
                0,0));
        panelHero.add(labelAttack2, new GridBagConstraints(1, 6, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(5,5,5,5),
                0,0));
        panelHero.add(labelDefense1, new GridBagConstraints(0, 7, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(5,5,5,5),
                0,0));
        panelHero.add(labelDefense2, new GridBagConstraints(1, 7, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(5,5,5,5),
                0,0));
        panelHero.add(labelArtefacts, new GridBagConstraints(0, 8, 2, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(5,5,5,5),
                0,0));
        panelHero.add(labelWeapon1, new GridBagConstraints(0, 9, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(5,5,5,5),
                0,0));
        panelHero.add(labelWeapon2, new GridBagConstraints(1, 9, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(5,5,5,5),
                0,0));
        panelHero.add(labelArmor1, new GridBagConstraints(0, 10, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(5,5,5,5),
                0,0));
        panelHero.add(labelArmor2, new GridBagConstraints(1, 10, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(5,5,5,5),
                0,0));
    }

    private void createHeroTools() {

        panelHero = new JPanel();
        heroBtn = new JButton("Hero");
        heroBtn.setEnabled(false);
        panelHero.setLayout(new GridBagLayout());
        labelYourHero = new JLabel("HERO");
        labelYourHero.setHorizontalAlignment(JLabel.CENTER);
        labelHeroName1 = new JLabel("Name");
        labelHeroName2 = new JLabel();
        labelHeroCass1 = new JLabel("Class");
        labelHeroCass2 = new JLabel();
        labelHeroLevel1 = new JLabel("Level");
        labelHeroLevel2 = new JLabel();
        labelHeroExp1 = new JLabel("Experience");
        labelHeroExp2 = new JLabel();
        labelAttack1 = new JLabel("Hero attack");
        labelAttack2 = new JLabel();
        labelDefense1 = new JLabel("Hero defense");
        labelDefense2 = new JLabel();
        labelArtefacts = new JLabel("Artefacts");
        labelArtefacts.setHorizontalAlignment(JLabel.CENTER);
        labelWeapon1 = new JLabel("Points plus to attack");
        labelWeapon2 = new JLabel();
        labelArmor1 = new JLabel("Points plus to defense");
        labelArmor2 = new JLabel();
        labelHealth1 = new JLabel("Health");
        labelHealth2 = new JLabel();
        /*jf.setLayout(new FlowLayout());
        jf.setSize(250, 350);
        //jf.pack();
        jf.setVisible(true);
        jf.setLocationRelativeTo(null);*/
    }

    private void createVillianTools() {

        panelVillian = new JPanel();
        panelVillian.setLayout(new GridBagLayout());
        villianBtn = new JButton("Villain");
        lableVillian = new JLabel("VILLAIN");
        lableVillian.setHorizontalAlignment(JLabel.CENTER);
        levellabel1 = new JLabel("Villian level");
        levellabel2 = new JLabel();
        attackLabel1 = new JLabel("Villian attack");
        attackLabel2 = new JLabel();
        defenseLabel1 = new JLabel("Villian degense");
        defenseLabel2 = new JLabel();
        artefactsLabel = new JLabel("Villian artefacts");
        weaponLabel1 = new JLabel("Points plus to attack");
        weaponLabel2 = new JLabel();
        armorLabel1 = new JLabel("Points plus to defense");
        armorLabel2 = new JLabel();
        healthLabel1 = new JLabel("Health");
        healthLabel2 = new JLabel();
        /*jf.setLayout(new FlowLayout());
        jf.setSize(220, 250);
        //jf.pack();
        jf.setResizable(false);

        jf.setVisible(true);
        jf.setLocationRelativeTo(null);*/
    }

    public void showLoser() {

        JOptionPane.showMessageDialog(allertFrame,
                "Good buy, LOSER!!!");
    }

    public void showWinner() {

        JOptionPane.showMessageDialog(allertFrame,
                "Perfectly!!!\nYou are winner");
    }

    public void showWinView() {

        JOptionPane.showMessageDialog(allertFrame,
                "You win villain");
    }

    public void exitWindow() {

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        WindowEvent windowEvent = new WindowEvent(jf, WindowEvent.WINDOW_CLOSING);
        jf.dispatchEvent(windowEvent);
    }

    public void closeWindow() {

        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        WindowEvent windowEvent = new WindowEvent(jf, WindowEvent.WINDOW_CLOSING);
        jf.dispatchEvent(windowEvent);
    }

    public JFrame getJf() {
        return jf;
    }

    public JLabel getLevellabel2() {
        return levellabel2;
    }

    public JLabel getAttackLabel2() {
        return attackLabel2;
    }

    public JLabel getDefenseLabel2() {
        return defenseLabel2;
    }

    public JLabel getWeaponLabel2() {
        return weaponLabel2;
    }

    public JLabel getArmorLabel2() {
        return armorLabel2;
    }

    public JLabel getHealthLabel2() {
        return healthLabel2;
    }

    public JLabel getLabelHeroName2() {
        return labelHeroName2;
    }

    public JLabel getLabelHeroCass2() {
        return labelHeroCass2;
    }

    public JLabel getLabelHeroLevel2() {
        return labelHeroLevel2;
    }

    public JLabel getLabelHeroExp2() {
        return labelHeroExp2;
    }

    public JLabel getLabelAttack2() {
        return labelAttack2;
    }

    public JLabel getLabelDefense2() {
        return labelDefense2;
    }

    public JLabel getLabelWeapon2() {
        return labelWeapon2;
    }

    public JLabel getLabelArmor2() {
        return labelArmor2;
    }

    public JLabel getLabelHealth2() {
        return labelHealth2;
    }

    public JLabel getTurnLable() {
        return turnLable;
    }

    public JButton getHeroBtn() {
        return heroBtn;
    }

    public JButton getVillianBtn() {
        return villianBtn;
    }


}
