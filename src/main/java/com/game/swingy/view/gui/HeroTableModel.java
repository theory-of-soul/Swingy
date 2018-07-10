package com.game.swingy.view.gui;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class HeroTableModel extends AbstractTableModel {

    private int columnCount = 10;
    private ArrayList<String []> dataArrayList;

    public HeroTableModel() {

        dataArrayList = new ArrayList<String []>();
        for (int i = 0; i < dataArrayList.size(); i++) {
            dataArrayList.add(new String[getColumnCount()]);
        }

    }

    @Override
    public int getRowCount() {
        return dataArrayList.size();
    }

    @Override
    public int getColumnCount() {
        return columnCount;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String []rows = dataArrayList.get(rowIndex);
        return rows[columnIndex];
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0: return "name";
            case 1: return "heroClass";
            case 2: return "level";
            case 3: return "attack";
            case 4: return "defense";
            case 5: return "hitPoints";
            case 6: return "weapon";
            case 7: return "armor";
            case 8: return "helm";
            case 9: return "experience";
        }
        return "";
    }

    public void addDate(String []row) {

        String []rowTable = new String[getColumnCount()];
        rowTable = row;
        dataArrayList.add(rowTable);
    }

    public void delRow(int row) {
        dataArrayList.remove(row);
    }
}
