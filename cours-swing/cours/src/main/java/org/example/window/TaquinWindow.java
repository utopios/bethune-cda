package org.example.window;

import lombok.Data;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

@Data
public class TaquinWindow {
    private int size = 4;
    private JPanel taquinPanel;
    private GridBagLayout gridBagLayout;
    private GridBagConstraints gridBagConstraints;

    private int[] numbers = new int[(size*size)-1];

    public TaquinWindow() {
        gridBagLayout = new GridBagLayout();
        taquinPanel.setLayout(gridBagLayout);
        for(int i=1; i < size*size; i++) {
            numbers[i-1] = i;
        }
        gridBagConstraints = new GridBagConstraints();
        shuffle();
        createButton();
    }

    private void shuffle() {
        Random r = new Random();
        for(int i=0; i<numbers.length; i++) {
            int alea = r.nextInt(numbers.length);
            int tmp = numbers[i];
            numbers[i] = numbers[alea];
            numbers[alea] = tmp;
        }
    }

    private void createButton() {
        int x = 0, y = 0;
        for (int n: numbers) {
            JButton b = new JButton(String.valueOf(n));
            gridBagConstraints.gridx = x;
            gridBagConstraints.gridy = y;
            if((x+1)%size == 0) {
                y++;
                x = 0;
            }
            else {
                x++;
            }
            taquinPanel.add(b, gridBagConstraints);
        }
    }
}
