package com.game.swingy.core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmptyButtonListener implements ActionListener {

    private int coordinateX;
    private int coordinateY;

    protected EmptyButtonListener(int x, int y) {
        this.coordinateX = x;
        this.coordinateY = y;
    }

    public void actionPerformed(ActionEvent e) {

    }

    protected int getCoordinateX() {
        return coordinateX;
    }

    protected int getCoordinateY() {
        return coordinateY;
    }
}
