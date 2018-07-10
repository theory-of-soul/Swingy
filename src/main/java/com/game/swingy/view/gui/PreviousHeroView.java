package com.game.swingy.view.gui;

import javax.swing.*;
import java.awt.*;

public class PreviousHeroView {

    public PreviousHeroView() {
        JFrame frame = new JFrame("Swingy Load");
        frame.setSize(new Dimension(850, 400));
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new GridBagLayout());

        JButton loadBtn = new JButton("Load hero");
        JButton deleteBtn = new JButton("Delete hero");


        HeroTableModel htm = new HeroTableModel();
        JTable heroTable = new JTable(htm);
        JScrollPane heroTableScrollPane = new JScrollPane(heroTable);
        heroTableScrollPane.setPreferredSize(new Dimension(850, 200));

        String []str = new String[10];
        str[0] = "pip";
        str[1] = "semnite";
        str[2] = "1";
        str[3] = "22";
        str[4] = "21";
        str[5] = "100";
        str[6] = "10";
        str[7] = "1";
        str[8] = "3";
        str[9] = "1200";

        htm.addDate(str);


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
}

/*
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellRenderer;

//OUR MAIN CLASS
public class PreviousHeroView extends JFrame {

    public PreviousHeroView(){
        //FORM TITLE
        super("Button Column Example");

        //DATA FOR OUR TABLE
        Object[][] data=
                {
                        {"1","Man Utd",new Integer(2013),"21"},
                        {"2","Man City",new Integer(2014),"3"},
                        {"3","Chelsea",new Integer(2015),"7"},
                        {"4","Arsenal",new Integer(1999),"10"},
                        {"5","Liverpool",new Integer(1990),"19"},
                        {"6","Everton",new Integer(1974),"1"},
                };

        //COLUMN HEADERS
        String columnHeaders[]={"Position","Team","Last Year Won","Trophies"};
        //CREATE OUR TABLE AND SET HEADER
        JTable table=new JTable(data,columnHeaders);

        //SET CUSTOM RENDERER TO TEAMS COLUMN
        table.getColumnModel().getColumn(1).setCellRenderer(new ButtonRenderer());;

        //SET CUSTOM EDITOR TO TEAMS COLUMN
        table.getColumnModel().getColumn(1).setCellEditor(new ButtonEditor(new JTextField()));

        //SCROLLPANE,SET SZE,SET CLOSE OPERATION
        JScrollPane pane=new JScrollPane(table);
        getContentPane().add(pane);
        setSize(450,100);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}

//BUTTON RENDERER CLASS
class ButtonRenderer extends JButton implements  TableCellRenderer
{

    //CONSTRUCTOR
    public ButtonRenderer() {
        //SET BUTTON PROPERTIES
        setOpaque(true);
    }
    @Override
    public Component getTableCellRendererComponent(JTable table, Object obj,
                                                   boolean selected, boolean focused, int row, int col) {

        //SET PASSED OBJECT AS BUTTON TEXT
        setText((obj==null) ? "":obj.toString());

        return this;
    }

}

//BUTTON EDITOR CLASS
class ButtonEditor extends DefaultCellEditor {
    protected JButton btn;
    private String lbl;
    private Boolean clicked;

    public ButtonEditor(JTextField txt) {
        super(txt);

        btn = new JButton();
        btn.setOpaque(true);

        //WHEN BUTTON IS CLICKED
        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                fireEditingStopped();
            }
        });
    }

    //OVERRIDE A COUPLE OF METHODS
    @Override
    public Component getTableCellEditorComponent(JTable table, Object obj,
                                                 boolean selected, int row, int col) {

        //SET TEXT TO BUTTON,SET CLICKED TO TRUE,THEN RETURN THE BTN OBJECT
        lbl = (obj == null) ? "" : obj.toString();
        btn.setText(lbl);
        clicked = true;
        return btn;
    }

    //IF BUTTON CELL VALUE CHNAGES,IF CLICKED THAT IS
    @Override
    public Object getCellEditorValue() {

        if (clicked) {
            //SHOW US SOME MESSAGE
            JOptionPane.showMessageDialog(btn, lbl + " Clicked");
        }
        //SET IT TO FALSE NOW THAT ITS CLICKED
        clicked = false;
        return new String(lbl);
    }

    @Override
    public boolean stopCellEditing() {

        //SET CLICKED TO FALSE FIRST
        clicked = false;
        return super.stopCellEditing();
    }

    @Override
    protected void fireEditingStopped() {
        
        super.fireEditingStopped();
    }
}*/

/*
import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

import javax.swing.table.TableModel;

import javax.swing.table.DefaultTableModel;

import javax.swing.table.*;

public class PreviousHeroView extends JFrame

{

    private JPanel topPanel,topPanel1;

    private JTable table;

    private JScrollPane scrollPane,scrollPane1;

    private String[] columnNames= new String[3];

    private String[][] dataValues=new String[3][3] ;

    JButton button = new JButton();

    public PreviousHeroView()

    {

        setTitle("Button in JTable Cell");

        setSize(300,300);

        topPanel= new JPanel();

        topPanel.setLayout(new BorderLayout());

        getContentPane().add(topPanel);

        columnNames=new String[] {"Column 1" , "Column 2" , "Test", "Column 3"};

        dataValues = new String[][]              {

                {"1","2",},
                {"11","22",},

        {"4","5",},

        {"7","8",}};

        TableModel model=new myTableModel("owntable");

        table =new JTable( );

        table.setModel(model);

        table.getColumn("Column 3").setCellRenderer(new ButtonRenderer());

        table.getColumn("Column 3").setCellEditor(new ButtonEditor(new JCheckBox()));

        scrollPane=new JScrollPane(table);

        topPanel.add(scrollPane,BorderLayout.CENTER);

        button.addActionListener(

                new ActionListener()

                {

                    public void actionPerformed(ActionEvent event)

                    {

                        JOptionPane.showMessageDialog(null,"Button Clicked in JTable Cell");

                    }

                }

        );

    }

    class ButtonRenderer extends JButton implements TableCellRenderer {

        public ButtonRenderer() {

            setOpaque(true);

        }

        public Component getTableCellRendererComponent(JTable table, Object value,

                                                       boolean isSelected, boolean hasFocus, int row, int column) {

            setText((value == null) ? "" : value.toString());

            return this;

        }

    }

    class ButtonEditor extends DefaultCellEditor {

        private String label;

        public ButtonEditor(JCheckBox checkBox) {

            super(checkBox);

        }

        public Component getTableCellEditorComponent(JTable table, Object value,

                                                     boolean isSelected, int row, int column) {

            label = (value == null) ? "" : value.toString();

            button.setText(label);

            return button;

        }

        public Object getCellEditorValue() {

            return new String(label);

        }

    }

    public class myTableModel extends DefaultTableModel

    {

        String dat;

        JButton button=new JButton("");

        myTableModel(String tname)

        {

            super(dataValues,columnNames);

            dat=tname;

        }

        public boolean isCellEditable(int row,int cols)

        {

            if( dat=="owntable")

            {

                if(cols==0){return false;}

            }

            return true;

        }

    }
}*/
