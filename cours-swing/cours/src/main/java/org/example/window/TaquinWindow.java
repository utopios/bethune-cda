package org.example.window;

import lombok.Data;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

@Data
public class TaquinWindow {
    private int size = 3;
    private JPanel taquinPanel;

    private JButton startButton;
    private JTextField textField;
    private JLabel headerLabel;
    private FlowLayout flowLayout;
    private JPanel headerPanel;

    private JPanel mainPanel;
    private GridBagLayout gridBagLayout;

    private GridLayout gridLayout;
    private GridBagConstraints gridBagConstraints;

    private int[] numbers;

    public TaquinWindow() {
        gridLayout = new GridLayout(2, 1);
        mainPanel.setLayout(gridLayout);
        mainPanel.setSize(500,500);
        createHeader();
        createTaquin();

    }

    private void createHeader() {
        flowLayout = new FlowLayout();
        headerPanel = new JPanel();
        headerPanel.setLayout(flowLayout);
        headerLabel = new JLabel("Taille du jeu");
        textField = new JTextField();
        textField.setSize(300,10);
        startButton = new JButton("Démarrer");
        startButton.addActionListener((e) -> {
            size = Integer.valueOf(textField.getText());
            mainPanel.remove(taquinPanel);
            createTaquin();
            mainPanel.validate();
        });
        headerPanel.add(headerLabel);
        headerPanel.add(textField);
        headerPanel.add(startButton);
        mainPanel.add(headerPanel);
    }

    private void createTaquin() {
        numbers = new int[(size*size)-1];
        taquinPanel = new JPanel();
        gridBagLayout = new GridBagLayout();
        taquinPanel.setLayout(gridBagLayout);
        for(int i=1; i < size*size; i++) {
            numbers[i-1] = i;
        }
        gridBagConstraints = new GridBagConstraints();
        shuffle();
        createButton();
        mainPanel.add(taquinPanel);
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
            b.addActionListener((e) -> clickButton(e));
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

    private void clickButton(ActionEvent e) {
        JButton b = (JButton) e.getSource();
        int x = gridBagLayout.getConstraints(b).gridx;
        int y = gridBagLayout.getConstraints(b).gridy;
        if( y < size-1 && emptySpot(x, y+1)) {
            moveButton(b, x, y+1);
        }
        else if(y > 0 && emptySpot(x, y-1)) {
            moveButton(b, x, y-1);
        }
        else if( x < size - 1 && emptySpot(x+1, y)) {
            moveButton(b, x+1, y);
        }
        else if(x > 0 && emptySpot(x-1, y)) {
            moveButton(b, x-1, y);
        }
    }

    private void moveButton(JButton b, int x, int y) {
        System.out.println("X : "+ x + " Y : "+ y + " | "+b.getText());
        gridBagConstraints.gridx = x;
        gridBagConstraints.gridy = y;

        gridBagLayout.setConstraints(b, gridBagConstraints);
        taquinPanel.revalidate();
    }

    private boolean emptySpot(int x, int y) {
        boolean result = true;
        for(Component c: taquinPanel.getComponents()) {
            int xC = gridBagLayout.getConstraints(c).gridx;
            int yC = gridBagLayout.getConstraints(c).gridy;
            if(x == xC && y == yC) {
                result = false;
                break;
            }
        }
        return  result;
    }


}
