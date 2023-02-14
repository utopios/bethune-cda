package org.example.window;

import lombok.Data;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Data
public class FirstWindow {
   /* private JButton firstButton;*/
    private JPanel firstPanel;
    private int count = 0;
    public FirstWindow() {
        /*firstButton.setText("Je suis un bouton");

        //Event sur le click
        *//*firstButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count++;
                firstButton.setText(firstButton.getText() + " click : "+count);
            }
        });*//*
        firstButton.addActionListener((e) -> {
            System.out.println(e);
            count++;
            firstButton.setText(((JButton)e.getSource()).getText() + " Click : "+count);
        });*/
        //Utilisation des GridLayout
        /*firstPanel.setLayout(new GridLayout(3,3));
        for(int i=1; i <= 9; i++) {
            JButton b = new JButton("b" + i);
            b.addActionListener((e) -> {
                System.out.println(((JButton)e.getSource()).getText());
            });
            firstPanel.add(b);
        }*/
        //Utilisation des GridBagLayout
        GridBagLayout g = new GridBagLayout();
        g.columnWidths = new int[6];
        g.rowHeights = new int[6];
        firstPanel.setLayout(new GridBagLayout());
        for(int i=0; i < 3; i++) {
            for(int j=0; j < 3; j++) {
                JButton b = new JButton("b" + i+ " X "+j);
                GridBagConstraints c = new GridBagConstraints();
                //c.fill = GridBagConstraints.HORIZONTAL;
                c.gridy = j;
                c.gridx = i;
                c.weightx = 1;
                c.weighty = 1;
                c.fill = GridBagConstraints.BOTH;
                if(i == 0 && j == 0) {
                    c.gridwidth = 2;
                    //c.fill = GridBagConstraints.HORIZONTAL;
                }
                if(i==1 && j ==1) {
                    c.gridheight = 2;
                    //c.fill = GridBagConstraints.VERTICAL;
                }

                b.addActionListener((e) -> {
                    System.out.println(((JButton)e.getSource()).getText());
                });
                firstPanel.add(b, c);
            }
        }
    }
}
