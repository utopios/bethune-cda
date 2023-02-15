package org.example;

import org.example.window.CalculatriceWindow;
import org.example.window.FirstWindow;
import org.example.window.TaquinWindow;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        //Création d'une Frame
        /*JFrame mainFrame = new JFrame("La première frame");
        mainFrame.setSize(new Dimension(1000,1000));
        mainFrame.setContentPane(new FirstWindow().getFirstPanel());
        mainFrame.setVisible(true);*/
        /*JFrame calcuatriceFrame = new JFrame("Calculatrice ios");
        calcuatriceFrame.setSize(new Dimension(300,600));
        calcuatriceFrame.setContentPane(new CalculatriceWindow().getCalculatricePanel());
        calcuatriceFrame.setVisible(true);*/

        JFrame taquinFrame = new JFrame("Taquin ios");
        taquinFrame.setSize(new Dimension(400,400));
        taquinFrame.setContentPane(new TaquinWindow().getMainPanel());
        taquinFrame.setVisible(true);
    }
}