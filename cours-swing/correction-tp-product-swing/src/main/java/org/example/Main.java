package org.example;

import org.example.panel.FormProductPanel;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Formulaire produit");
        frame.setSize(new Dimension(500,300));
        frame.setContentPane(new FormProductPanel(frame).getMainPanel());
        frame.setVisible(true);
    }
}