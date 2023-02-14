package org.example.window;

import lombok.Data;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;

@Data
public class CalculatriceWindow {
    private JPanel calculatricePanel;
    private JLabel blackScreen;
    private GridBagLayout bagLayout;
    private GridBagConstraints bagConstraints;

    private String[] buttons = new String[] {"C", "+/-", "%", "/", "7", "8", "9", "X", "4", "5", "6", "-", "1", "2", "3", "+", "0", ",", "="};


    public  CalculatriceWindow(){
        bagLayout = new GridBagLayout();
        calculatricePanel.setLayout(bagLayout);
        bagConstraints = new GridBagConstraints();
        bagConstraints.fill = GridBagConstraints.BOTH;
        createBlackScreen();
        createButton();
    }

    private void createBlackScreen() {
        blackScreen = new JLabel("0");
        blackScreen.setForeground(Color.WHITE);
        blackScreen.setBackground(Color.BLACK);
        blackScreen.setOpaque(true);
        blackScreen.setFont(new Font(null,0, 30));
        blackScreen.setHorizontalAlignment(SwingConstants.RIGHT);
        blackScreen.setVerticalAlignment(SwingConstants.BOTTOM);
        bagConstraints.weighty = 1;

        bagConstraints.gridwidth = 5;
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 0;
        calculatricePanel.add(blackScreen,bagConstraints);
    }

    private void actionButton(ActionEvent e) {
        JButton b = (JButton) e.getSource();
        blackScreen.setText(b.getText());
    }
    private void createButton() {
        int x = 0;
        int y = 1;
        for(String s: buttons) {
            JButton button = new JButton(s);
            button.addActionListener((e) -> {
                actionButton(e);
            });
            bagConstraints.gridx = x;
            bagConstraints.gridy = y;
            bagConstraints.weightx = 0.5;
            bagConstraints.weighty = 0.5;

            if(s.equals("0")) {
                bagConstraints.gridwidth = 2;
                x++;
            }
            else {
                bagConstraints.gridwidth = 1;
            }
            if((x+1)%4 == 0){
                button.setBackground(Color.orange);
                button.setOpaque(true);
                button.setBorderPainted(false);
                button.setForeground(Color.WHITE);
                y++;
                x = 0;
            }
            else {
                x++;
            }
            calculatricePanel.add(button, bagConstraints);

        }
    }


}
