package org.example;

import org.example.window.FirstWindow;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        //Création d'une Frame
        JFrame mainFrame = new JFrame("La première frame");
        mainFrame.setSize(new Dimension(1000,1000));
        mainFrame.setContentPane(new FirstWindow().getFirstPanel());
        mainFrame.setVisible(true);
    }
}