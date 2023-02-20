package org.example;

import org.example.panel.CartPanel;
import org.example.panel.FormProductPanel;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Formulaire produit");
        frame.setSize(new Dimension(500,300));
        frame.setContentPane(new CartPanel(frame).getMainPanel());
        frame.setVisible(true);
    }
}