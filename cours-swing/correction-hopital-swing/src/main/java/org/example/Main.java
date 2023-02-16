package org.example;

import org.example.window.HomePanel;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Gestion Hopital");
        frame.setSize(new Dimension(600,600));
        frame.setContentPane(new HomePanel(frame).getMainPanel());
        frame.setVisible(true);
    }
}