package org.example.window;

import lombok.Data;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
public class ListPanel {
    private JPanel mainPanel;
    private JList demoList;

    private GridLayout gridLayout;
    private ArrayList<String> data = new ArrayList<>();

    private JTextField textField;
    private JButton button;
    public  ListPanel() {
        data.add("toto");
        data.add("titit");
        textField = new JTextField();
        button = new JButton("Ajouter");
        button.addActionListener((e) -> {
            data.add(textField.getText());
            demoList.setListData(data.toArray());
        });
        demoList = new JList(data.toArray());
        demoList.addListSelectionListener(e -> {
            textField.setText(demoList.getSelectedValue().toString());
        });
        mainPanel = new JPanel();
        gridLayout = new GridLayout();
        mainPanel.setLayout(gridLayout);
        mainPanel.add(textField);
        mainPanel.add(button);
        mainPanel.add(demoList);
    }
}
