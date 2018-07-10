package com.game.swingy.core.Map;

import com.game.swingy.core.Unit.Unit;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class CloseMapWindowListener implements WindowListener {

    private Unit unit;

    protected CloseMapWindowListener(Unit unit) {

        this.unit = unit;
    }

    public void windowOpened(WindowEvent var1) {

    }

    public void windowClosing(WindowEvent var1) {

    }

    public void windowClosed(WindowEvent var1) {

    }

    public void windowIconified(WindowEvent var1) {

    }

    public void windowDeiconified(WindowEvent var1) {

    }

    public void windowActivated(WindowEvent var1) {

    }

    public void windowDeactivated(WindowEvent var1) {

    }

    protected Unit getUnit() {
        return unit;
    }
}
