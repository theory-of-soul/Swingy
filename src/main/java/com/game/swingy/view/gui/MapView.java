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

    public MapView(int mapSize) {

        //heroClass = new String[] {"Samnite", "Skissor", "Peltasts"};
        btnUnits = new JButton[mapSize][mapSize];
        jf = new JFrame("Swingy");
        content = jf.getContentPane();
        panel = new JPanel(new GridLayout(mapSize,mapSize));
        panel.setSize(mapSize * 95,mapSize * 95);
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++){
                btnUnits[i][j] = new JButton("button" + i + j);
                try {
                    Image img = ImageIO.read(getClass().getResource("/main/java/com/game/swingy/utils/superman.bmp"));
                    btnUnits[i][j].setIcon(new ImageIcon(getClass().getResource("/src/main/java/com/game/swingy/utils/superman.bmp")));
                } catch (Exception ex) {
                    System.out.println(ex);
                }
                System.out.println();
                panel.add(btnUnits[i][j]);
            }
        }
        content.add(panel);
        jf.setSize(mapSize * 95, mapSize * 95);
        jf.setVisible(true);
        jf.setLocationRelativeTo(null);

    }
}
