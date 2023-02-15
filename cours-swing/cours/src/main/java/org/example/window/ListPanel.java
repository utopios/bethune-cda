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

    private JTable jTable;
    private JTextField textField;
    private JButton button;
    private String[][] dataTable = new String[][]{
            {"toto", "tata", "20"},
            {"titi", "minet", "30"},

    };
    public  ListPanel() {
        data.add("toto");
        data.add("titit");
        textField = new JTextField();
        jTable = new JTable(dataTable, new String[] {"nom", "prenom", "age"});
        jTable.setBounds(10,10,300,300);
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
        mainPanel.add(jTable);
    }
}
