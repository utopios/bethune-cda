package org.example.window;

import com.example.tphopital.entity.Patient;
import com.example.tphopital.exception.StringFormatException;
import lombok.Data;
import org.example.adapter.PatientModel;

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
    public  ListPanel() throws StringFormatException {
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
        //JTable
        //jTable = new JTable(dataTable, new String[] {"nom", "prenom", "age"});
        //mainPanel.add( new JScrollPane(jTable));
        //Jtable avec model
        jTable = new JTable();
        Patient p1 = new Patient();
        p1.setNom("toto");
        p1.setPrenom("titi");
        ArrayList<Patient> patients = new ArrayList<>();
        patients.add(p1);
        PatientModel model = new PatientModel(patients);
        jTable.setModel(model);

        mainPanel.add( new JScrollPane(jTable));
    }
}
