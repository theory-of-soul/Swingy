package com.game.swingy.view.gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

public class MapView {

    private JFrame jf;
    private JLabel labelName;
    private JLabel labelHeroType;
    private JPanel panel;
    private Container content;
    private JTextField nameHero;
    private JButton btnUnits[][];
    private String[] heroClass;
    private JComboBox<String> heroClassList;
    private int mapSize;

    public MapView(int mapSize) {

        this.mapSize = mapSize;
        btnUnits = new JButton[mapSize][mapSize];
        jf = new JFrame("Swingy");
        content = jf.getContentPane();
        panel = new JPanel(new GridLayout(mapSize,mapSize));
        panel.setSize(mapSize * 95,mapSize * 95);
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++){
                    btnUnits[i][j] = new JButton();
                panel.add(btnUnits[i][j]);
            }
        }
        content.add(panel);
        jf.setSize(mapSize * 95, mapSize * 95);
        jf.setVisible(true);
        jf.setLocationRelativeTo(null);
        setHeroIcon(mapSize / 2, mapSize / 2);

    }

    public JButton getBtnUnits(int x, int y) {

        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++){
                if (i == x && j == y)
                    return btnUnits[i][j];
            }
        }
        throw new Error("Not valid x and y coordinats");
    }

    public void btnUnitsDeActivated(int x, int y) {

        btnUnits[x][y].setEnabled(false);
    }

    public void btnUnitsActivated(int x, int y) {

        btnUnits[x][y].setEnabled(true);
    }

   /* public void changeIconButton(int heroX, int heroY) {

        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++){
                if (i == heroX && j == heroY)
                    setHeroIcon(i, j);
                else
                    btnUnits[i][j].setText("Villain");
            }
        }
    }*/

    public JButton[][] getBtnUnits() {
        return btnUnits;
    }

    public void setHeroIcon(int x, int y) {

        try {
            Image img = ImageIO.read(getClass().getResource("/superman.png")); //TODO зробити нормальну картинку і правильно її присвоїти на кнопку
            Image newimg = img.getScaledInstance(btnUnits[x][y].getWidth(), btnUnits[mapSize / 2][mapSize / 2].getHeight(), Image.SCALE_DEFAULT);
            btnUnits[x][y].setIcon(new ImageIcon(newimg));
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void setVilliansIcon(int x, int y) {

        try {
            Image img = ImageIO.read(getClass().getResource("/villian.jpg")); //TODO зробити нормальну картинку і правильно її присвоїти на кнопку
            Image newimg = img.getScaledInstance(btnUnits[x][y].getWidth(), btnUnits[x][y].getHeight(), Image.SCALE_DEFAULT);
            btnUnits[x][y].setIcon(new ImageIcon(newimg));
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    public void setEmptyIcon(int x, int y) {

        btnUnits[x][y].setIcon(null);
    }
}
