package com.game.swingy.core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FightButtonListener implements ActionListener {

    private Unit villian;

    protected FightButtonListener(Unit villian) {

        this.villian = villian;
    }

    public void actionPerformed(ActionEvent e) {

    }

    public Unit getVillian() {
        return villian;
    }
}
