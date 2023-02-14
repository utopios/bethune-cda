package org.example.window;

import lombok.Data;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Data
public class FirstWindow {
    private JButton firstButton;
    private JPanel firstPanel;
    private JRadioButton radioButton1;
    private JButton button2;
    private JButton button3;
    private int count = 0;
    public FirstWindow() {
        firstButton.setText("Je suis un bouton");

        //Event sur le click
        /*firstButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count++;
                firstButton.setText(firstButton.getText() + " click : "+count);
            }
        });*/
        firstButton.addActionListener((e) -> {
            System.out.println(e);
            count++;
            firstButton.setText(((JButton)e.getSource()).getText() + " Click : "+count);
        });
    }
}
