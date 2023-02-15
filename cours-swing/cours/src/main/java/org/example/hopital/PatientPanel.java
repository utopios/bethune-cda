package org.example.hopital;

import lombok.Data;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

@Data
public class PatientPanel {
    private JPanel mainPanel;
    private GridLayout mainGridLayout;

    private JPanel formPanel;
    private GridBagLayout formGridLayout;
    private GridBagConstraints formBagConstraints;

    private JTextField codeTextField;
    private JTextField nomTextField;
    private JTextArea adresseTextArea;
    private JRadioButton mRadio;
    private JRadioButton fRadio;

    private List<String> labels = Arrays.asList("CODE", "NOM", "ADRESSE", "DATE DE NAISSANCE", "SEXE");

    public PatientPanel() {
        init();
    }

    private void init() {
        mainGridLayout = new GridLayout(1,2);
        mainPanel.setLayout(mainGridLayout);

        //Creation du formulaire
        createForm();
    }

    private void createForm() {
        formPanel = new JPanel();
        formGridLayout = new GridBagLayout();
        formBagConstraints = new GridBagConstraints();
        formPanel.setLayout(formGridLayout);
        mainPanel.add(formPanel);

        createLabelForm();
        createFieldForm();
    }

    private void createLabelForm() {
        int y = 0;
        for(String s: labels) {
            Label l = new Label(s);
            formBagConstraints.weightx = 0.5;
            formBagConstraints.gridy = y++;
            formBagConstraints.gridx = 0;
            formPanel.add(l, formBagConstraints);
        }
    }

    private void createFieldForm() {
        formBagConstraints.gridx = 1;
        formBagConstraints.weightx = 1;
        formBagConstraints.fill = GridBagConstraints.BOTH;
        codeTextField = new JTextField();
        formBagConstraints.gridy = 0;
        formPanel.add(codeTextField, formBagConstraints);

        nomTextField = new JTextField("");
        formBagConstraints.gridy = 1;
        formPanel.add(nomTextField, formBagConstraints);

        adresseTextArea = new JTextArea("");
        formBagConstraints.gridy = 2;
        formPanel.add(adresseTextArea, formBagConstraints);


    }

}
