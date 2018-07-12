package com.game.swingy.view.gui;

import com.game.swingy.controller.MapController;
import com.game.swingy.core.Map.Map;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PreviousHeroView {

    private JFrame frame;
    private HeroTableModel htm;
    private JButton loadBtn;
    private JButton deleteBtn;
    private JTable heroTable;
    private JScrollPane heroTableScrollPane;

    public PreviousHeroView() {

    }

    public void initPreviousHeroView() {

        createTools();
        Map.getMap().getDbMySQL().getData();

        frame.add(heroTableScrollPane, new GridBagConstraints(0, 0, 2, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.BOTH,
                new Insets(1, 1, 1, 1), 0, 0));
        frame.add(loadBtn, new GridBagConstraints(0, 1, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(1, 1, 1, 1), 0, 0));
        frame.add(deleteBtn, new GridBagConstraints(1, 1, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(1, 1, 1, 1), 0, 0));
        frame.setVisible(true);
        frame.pack();
    }

    private void createTools() {

        frame = new JFrame("Swingy Load");
        frame.setSize(new Dimension(850, 400));
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new GridBagLayout());

        loadBtn = new JButton("Load hero");
        deleteBtn = new JButton("Delete hero");

        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int confirmed = JOptionPane.showConfirmDialog(null,
                        "Are you sure you want to delete hero?",
                        "Deleting Swingy Hero",
                        JOptionPane.YES_NO_OPTION);

                if (confirmed == 0) {
                    int selectedRow = heroTable.getSelectedRow();
                    Object object = heroTable.getValueAt(selectedRow, 0);
                    String id = object.toString();
                    System.out.println(selectedRow);
                    htm.delRow(selectedRow);
                    htm.fireTableDataChanged();
                    Map.getMap().getDbMySQL().deleteRow(Integer.parseInt(id));
                }
            }
        });

        loadBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int confirmed = JOptionPane.showConfirmDialog(null,
                        "Are you sure you want to load hero?",
                        "Loading Swingy Hero",
                        JOptionPane.YES_NO_OPTION);

                if (confirmed == 0) {
                    //TODO load hero
                    int selectedRow = heroTable.getSelectedRow();
                    Object object = heroTable.getValueAt(selectedRow, 0);
                    String id = object.toString();
                    Map.getMap().getDbMySQL().getSelectedHero(Integer.parseInt(id));
                    Map.getMap().getDbMySQL().getSelectedVillain(Integer.parseInt(id));
                    MapController mapController = new MapController();
                    mapController.setVillainIcon();
                    frame.dispose();

                }
            }
        });

        htm = new HeroTableModel();
        heroTable = new JTable(htm);
        heroTableScrollPane = new JScrollPane(heroTable);
        heroTableScrollPane.setPreferredSize(new Dimension(850, 200));
    }

    public JFrame getFrame() {
        return frame;
    }

    public HeroTableModel getHtm() {
        return htm;
    }
}