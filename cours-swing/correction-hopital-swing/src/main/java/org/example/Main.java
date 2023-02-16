package org.example;

import org.example.component.MenuPanel;
import org.example.window.HomePanel;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Gestion Hopital");
        frame.setSize(new Dimension(600,600));
        new MenuPanel(frame);
        frame.setContentPane(new HomePanel(frame).getMainPanel());
        frame.setVisible(true);
    }
}