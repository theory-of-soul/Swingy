package com.game.swingy;


import javax.swing.*;  //importing swing package
import java.awt.*;     //importing awt package
public class Starter
{
    JFrame jf;
    public Starter() {
        jf = new JFrame("Swingy");		//Creating a JFrame with name MyWindow
        JButton btnCreateHero = new JButton("Create a hero");//Creating a Button named Say Hello
        JButton btnPreviouslyHero = new JButton("Select a previously created hero");//Creating a Button named Say Hello
        jf.add(btnCreateHero);             		//adding button to frame
        jf.add(btnPreviouslyHero);             		//adding button to frame
        jf.setLayout(new FlowLayout());        //setting layout using FlowLayout object
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//setting close  operation.
        jf.setSize(400, 400);            	//setting size
        jf.setVisible(true);            	//setting frame visibility
    }
    public static void main(String[] args)
    {
        new Starter();
    }
}
/*
public class Starter {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
*/
