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
        //heroClass = new String[] {"Samnite", "Skissor", "Peltasts"};
        btnUnits = new JButton[mapSize][mapSize];
        jf = new JFrame("Swingy");
        content = jf.getContentPane();
        panel = new JPanel(new GridLayout(mapSize,mapSize));
        panel.setSize(mapSize * 95,mapSize * 95);
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++){
//                if (i == (mapSize / 2) && j == (mapSize / 2))
                    btnUnits[i][j] = new JButton();
//                else
                    btnUnits[i][j] = new JButton();
                panel.add(btnUnits[i][j]);
            }
        }
        content.add(panel);
        jf.setSize(mapSize * 95, mapSize * 95);
        jf.setVisible(true);
        jf.setLocationRelativeTo(null);
        setHeroIcon();
        setVilliansIcon();

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

    public void changeIconButton(int heroX, int heroY) {

        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++){
                if (i == heroX && j == heroY)
                    btnUnits[i][j].setText("Hero");
                else
                    btnUnits[i][j].setText("Villain");
            }
        }
    }

    public JButton[][] getBtnUnits() {
        return btnUnits;
    }

    private void setHeroIcon() {

        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                if (i == (mapSize / 2) && j == (mapSize / 2)) {
                    try {
                        Image img = ImageIO.read(getClass().getResource("/superman.png")); //TODO зробити нормальну картинку і правильно її присвоїти на кнопку
                        Image newimg = img.getScaledInstance(btnUnits[i][j].getWidth(), btnUnits[i][j].getHeight(), Image.SCALE_DEFAULT);
                        btnUnits[i][j].setIcon(new ImageIcon(newimg));
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                }
            }
        }
    }

    private void setVilliansIcon() {

        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                if (i != (mapSize / 2) || j != (mapSize / 2)) { //TODO правильно прописати умову розстановки картинок
                    try {
                        Image img = ImageIO.read(getClass().getResource("/villian.jpg")); //TODO зробити нормальну картинку і правильно її присвоїти на кнопку
                        Image newimg = img.getScaledInstance(btnUnits[i][j].getWidth(), btnUnits[i][j].getHeight(), Image.SCALE_DEFAULT);
                        btnUnits[i][j].setIcon(new ImageIcon(newimg));
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                }
            }
        }
    }
}
