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
    private ActionListener deleteRowCallback;

    public PreviousHeroView() {

        createTools();
        initPreviousHeroView();

    }

     private void initPreviousHeroView() {


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

        htm = new HeroTableModel();
        heroTable = new JTable(htm);
        heroTableScrollPane = new JScrollPane(heroTable);
        heroTableScrollPane.setPreferredSize(new Dimension(850, 200));
    }

    public void setDeleteAction(ActionListener action) {
        deleteBtn.addActionListener(action);
    }

    public void setLoadAction(ActionListener action) {
        loadBtn.addActionListener(action);
    }

    public JFrame getFrame() {
        return frame;
    }

    public HeroTableModel getHeroTableModel() {
        return htm;
    }
    public JTable getHeroTable() {
        return heroTable;
    }

}