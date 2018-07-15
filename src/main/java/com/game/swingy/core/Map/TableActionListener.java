package com.game.swingy.core.Map;

import com.game.swingy.view.gui.HeroTableModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TableActionListener implements ActionListener {

    private JTable heroTable;
    private HeroTableModel htm;
    private JFrame jFrame;

    protected TableActionListener(JTable heroTable, HeroTableModel htm) {
        this.heroTable = heroTable;
        this.htm = htm;
    }

    protected TableActionListener(JTable heroTable, HeroTableModel htm,
                                  JFrame jFrame) {
        this.heroTable = heroTable;
        this.htm = htm;
        this.jFrame = jFrame;
    }

    public void actionPerformed(ActionEvent e) {

    }

    public JTable getHeroTable() {
        return heroTable;
    }

    public HeroTableModel getHtm() {
        return htm;
    }

    public JFrame getjFrame() {
        return jFrame;
    }
}
