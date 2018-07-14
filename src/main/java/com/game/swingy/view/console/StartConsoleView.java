package com.game.swingy.view.console;

import com.game.swingy.view.StartView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class StartConsoleView implements StartView {

    private int inpute;

    public StartConsoleView() {
        System.out.println("Console game started\n" +
                "Select one option:\n" +
                "1 - Create a new hero\n" +
                "2 - Select a previously created hero\n");
        /*System.out.println("Write a name of hero:\n");
        System.out.println("Chose type of hero:\n" +
                "1 - Samnite\n" +
                "2 - Skissor\n" +
                "3 - Peltasts\n");
        System.out.println("Select a previously created hero:\n");*/
        Scanner sc = new Scanner(System.in); // object for scanner
        int no = sc.nextInt(); // similiarli Float,Double can be added to it as per the data type.
        System.out.println("you entered : "+no);
    }

    @Override
    public void createHero(ActionListener action) {
        Scanner sc = new Scanner(System.in); // object for scanner
        this.inpute = sc.nextInt(); // similiarli Float,Double can be added to it as per the data type.
        System.out.println("you entered : "+inpute);
    }





    @Override
    public void showPreviouslyHeroes(ActionListener action) {

    }

    public int getInpute() {
        return inpute;
    }
}
