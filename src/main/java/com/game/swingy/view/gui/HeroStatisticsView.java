package com.game.swingy.view.gui;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.Border;
import java.awt.*;

public class HeroStatisticsView {

    private JFrame jf;
    private JLabel labelYourHero;
    private JLabel labelHeroName1;
    private JLabel labelHeroName2;
    private JLabel labelHeroCass1;
    private JLabel labelHeroCass2;
    private JLabel labelHeroLevel1;
    private JLabel labelHeroLevel2;
    private JLabel labelHeroExp1;
    private JLabel labelHeroExp2;
    private JLabel labelArtefacts;
    private JLabel labelWeapon1;
    private JLabel labelWeapon2;
    private JLabel labelArmor1;
    private JLabel labelArmor2;
    private JLabel labelHelm1;
    private JLabel labelHelm2;
    private JPanel panelYourHero;
    private JPanel panelMain;
    private JPanel panelArtefacts;
    private JPanel panelArtefactsAll;
    private Container content;
    private JButton btnOk;

    public HeroStatisticsView() {


        createTools();
        panelYourHero.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
        panelMain.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
        content = jf.getContentPane();
        content.add(panelMain);
        panelYourHero.add(labelYourHero);
        panelMain.add(labelHeroName1);
        panelMain.add(labelHeroName2);
        panelMain.add(labelHeroCass1);
        panelMain.add(labelHeroCass2);
        panelMain.add(labelHeroLevel1);
        panelMain.add(labelHeroLevel2);
        panelMain.add(labelHeroExp1);
        panelMain.add(labelHeroExp2);
        panelArtefacts.add(labelArtefacts);
        panelArtefactsAll.add(labelWeapon1);
        panelArtefactsAll.add(labelWeapon2);
        panelArtefactsAll.add(labelArmor1);
        panelArtefactsAll.add(labelArmor2);
        panelArtefactsAll.add(labelHelm1);
        panelArtefactsAll.add(labelHelm2);
        jf.setLayout(new FlowLayout());
        jf.add(panelYourHero);
        jf.add(panelMain);
        jf.add(panelArtefacts);
        jf.add(panelArtefactsAll);
        content = jf.getContentPane();
        content.add(panelYourHero);
        content.add(panelMain);
        //jf.add(btnOk);
        jf.setSize(400, 400);
        jf.setVisible(true);
        jf.setLocationRelativeTo(null);
    }

    private void createTools() {

        jf = new JFrame("Hero Statistics");
        labelYourHero = new JLabel("Your hero");
        labelYourHero.setLocation(380,380);
        labelHeroName1 = new JLabel("Name");
        labelHeroName2 = new JLabel();
        labelHeroCass1 = new JLabel("Class");
        labelHeroCass2 = new JLabel();
        labelHeroLevel1 = new JLabel("Level");
        labelHeroLevel2 = new JLabel();
        labelHeroExp1 = new JLabel("Experience");
        labelHeroExp2 = new JLabel();
        labelArtefacts = new JLabel("Artefacts");
        labelWeapon1 = new JLabel("Weapon");
        labelWeapon2 = new JLabel();
        labelArmor1 = new JLabel("Armor");
        labelArmor2 = new JLabel();
        labelHelm1 = new JLabel("Helm");
        labelHelm2 = new JLabel();
        panelYourHero = new JPanel(new GridLayout(1, 1));
        panelMain = new JPanel(new GridLayout(7, 2));
        panelArtefacts = new JPanel(new GridLayout(1, 1));
        panelArtefactsAll = new JPanel(new GridLayout(3, 2));
        btnOk = new JButton("OK");
    }
}
