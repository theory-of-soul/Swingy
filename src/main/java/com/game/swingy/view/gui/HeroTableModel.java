package com.game.swingy.view.gui;

import javax.swing.table.AbstractTableModel;
import java.sql.Connection;
import java.util.ArrayList;

public class HeroTableModel extends AbstractTableModel {

    private int columnCount = 11;
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
            case 0: return "№ ID";
            case 1: return "name";
            case 2: return "heroClass";
            case 3: return "level";
            case 4: return "attack";
            case 5: return "defense";
            case 6: return "hitPoints";
            case 7: return "weapon";
            case 8: return "armor";
            case 9: return "helm";
            case 10: return "experience";
        }
        return "";
    }

    public void addDate(String []row) {

        String []rowTable;
        rowTable = row;
        dataArrayList.add(rowTable);
    }

    public void delRow(int row) {
        dataArrayList.remove(row);
    }

    public void addDataFromDB(Connection conn) {


    }
}
