package com.game.swingy.view.gui;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.WindowEvent;

public class VillianAllertView {

    private JFrame jf;
    private JFrame allertFrame;
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
    private JButton fightBtn;
    private JButton runBtn;
    private JPanel panelMain;
    private JPanel panelBtn;

    public VillianAllertView() {

        createTools();
        jf.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        panelMain.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
        panelMain.add(levellabel1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(5,5,5,5),
                0,0));
        panelMain.add(levellabel2, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(5,5,5,5),
                0,0));
        panelMain.add(attackLabel1, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(5,5,5,5),
                0,0));
        panelMain.add(attackLabel2, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(5,5,5,5),
                0,0));
        panelMain.add(defenseLabel1, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(5,5,5,5),
                0,0));
        panelMain.add(defenseLabel2, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(5,5,5,5),
                0,0));
        panelMain.add(artefactsLabel, new GridBagConstraints(0, 3, 2, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(5,5,5,5),
                0,0));
        artefactsLabel.setHorizontalAlignment(JLabel.CENTER);
        panelMain.add(weaponLabel1, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(5,5,5,5),
                0,0));
        panelMain.add(weaponLabel2, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(5,5,5,5),
                0,0));
        panelMain.add(armorLabel1, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(5,5,5,5),
                0,0));
        panelMain.add(armorLabel2, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(5,5,5,5),
                0,0));
        panelMain.add(healthLabel1, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(5,5,5,5),
                0,0));
        panelMain.add(healthLabel2, new GridBagConstraints(1, 6, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(5,5,5,5),
                0,0));
        panelBtn.add(fightBtn, BorderLayout.WEST);
        panelBtn.add(runBtn, BorderLayout.EAST);
        jf.add(panelMain);
        jf.add(panelBtn);

    }

    private void createTools() {

        allertFrame = new JFrame();
        jf = new JFrame("Swingy allert");
        panelMain = new JPanel();
        panelBtn = new JPanel();
        panelBtn.setLayout(new BorderLayout());
        panelMain.setLayout(new GridBagLayout());
        levellabel1 = new JLabel("Villain level");
        levellabel2 = new JLabel();
        attackLabel1 = new JLabel("Villain attack");
        attackLabel2 = new JLabel();
        defenseLabel1 = new JLabel("Villain degense");
        defenseLabel2 = new JLabel();
        artefactsLabel = new JLabel("Villain artefacts");
        weaponLabel1 = new JLabel("Points plus to attack");
        weaponLabel2 = new JLabel();
        armorLabel1 = new JLabel("Points plus to defense");
        armorLabel2 = new JLabel();
        healthLabel1 = new JLabel("Health");
        healthLabel2 = new JLabel();
        fightBtn = new JButton("FIGHT");
        runBtn = new JButton("RUN");
        jf.setLayout(new FlowLayout());
        jf.setSize(220, 250);
        //jf.pack();
        jf.setResizable(false);

        jf.setVisible(true);
        jf.setLocationRelativeTo(null);



    }

    public void showLucky() {

        JOptionPane.showMessageDialog(allertFrame,
                "That's you lucky");
    }

    public void showDisLucky() {

        JOptionPane.showMessageDialog(allertFrame,
                "That's you don't lucky");
    }

    public int showFightAllert() {

        return JOptionPane.showConfirmDialog(
                allertFrame,
                "Are you sure that you want fight with villain?",
                "Swingy allert Question",
                JOptionPane.YES_NO_OPTION);
    }

    public int showRunAllert() {

        return JOptionPane.showConfirmDialog(
                allertFrame,
                "You have 50% chance of returning to the previous position. " +
                        "If the odds aren’t on your side, you must fight the " +
                        "villian\nAre you sure that you want to run?",
                "Swingy allert Question",
                JOptionPane.YES_NO_OPTION);
    }
    public void closeWindow() {

        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        WindowEvent windowEvent = new WindowEvent(jf, WindowEvent.WINDOW_CLOSING);
        jf.dispatchEvent(windowEvent);
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

    public JButton getFightBtn() {
        return fightBtn;
    }

    public JButton getRunBtn() {
        return runBtn;
    }

    public JFrame getJf() {
        return jf;
    }
}
