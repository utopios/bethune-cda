package org.example.window;

import com.example.tphopital.entity.Patient;
import com.example.tphopital.exception.StringFormatException;
import com.example.tphopital.repository.impl.PatientRepository;
import com.example.tphopital.service.PatientService;
import com.toedter.calendar.JDateChooser;
import lombok.Data;

import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;

@Data
public class FormPatientPanel {
    private JPanel mainPanel;
    private GridLayout mainGridLayout;

    private JPanel formPanel;

    private JPanel boutonPanel;
    private JPanel radioPanel;
    private GridBagLayout formGridLayout;
    private GridBagConstraints formBagConstraints;

    private JTextField codeTextField;
    private JTextField nomTextField;
    private JTextArea adresseTextArea;

    private ButtonGroup buttonGroup;
    private JRadioButton mRadio;
    private JRadioButton fRadio;
    private JDateChooser calendar;

    private PatientRepository patientRepository;
    private PatientService patientService;
    private List<String> labels = Arrays.asList("CODE", "NOM", "ADRESSE", "DATE DE NAISSANCE", "SEXE");

    private JFrame _frame;
    public FormPatientPanel(JFrame frame) {
        _frame = frame;
        patientRepository = new PatientRepository();
        patientService = new PatientService(patientRepository);
        init();
    }

    private void init() {
        mainGridLayout = new GridLayout(1,2);
        mainPanel.setLayout(mainGridLayout);
        mainPanel.setBorder(BorderFactory.createTitledBorder("Patient"));
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
        createButton();
    }

    private void createButton() {
        boutonPanel = new JPanel();
        boutonPanel.setLayout(new GridLayout());
        mainPanel.add(boutonPanel);
        Button button = new Button("Enregister");
        button.addActionListener((e) -> {
            try {
                savePatient();
            } catch (StringFormatException ex) {
                throw new RuntimeException(ex);
            } catch (ParseException ex) {
                throw new RuntimeException(ex);
            }
        });
        boutonPanel.add(button);
    }

    private void createLabelForm() {
        int y = 0;
        for(String s: labels) {
            Label l = new Label(s);
            formBagConstraints.weightx = 0.5;
            formBagConstraints.weighty = (s.equals("ADRESSE")) ? 1 : 0.5;
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
        //formBagConstraints.weighty = 1;
        formPanel.add(adresseTextArea, formBagConstraints);

        calendar = new JDateChooser();
        formBagConstraints.gridy = 3;
        formPanel.add(calendar, formBagConstraints);

        radioPanel = new JPanel();
        buttonGroup = new ButtonGroup();

        fRadio = new JRadioButton("f");
        mRadio = new JRadioButton("m");
        radioPanel.setLayout(new FlowLayout());
        buttonGroup.add(fRadio);
        buttonGroup.add(mRadio);
        radioPanel.add(fRadio);
        radioPanel.add(mRadio);
        formBagConstraints.gridy = 4;
        formBagConstraints.fill = GridBagConstraints.CENTER;
        formPanel.add(radioPanel, formBagConstraints);
    }

    private void savePatient() throws StringFormatException, ParseException {
        Patient patient = new Patient();
        patient.setNss(codeTextField.getText());
        patient.setNom(nomTextField.getText());
        patient.setAdresse(adresseTextArea.getText());
        patientService.add(nomTextField.getText(),"rzer", "01010101", adresseTextArea.getText(), codeTextField.getText(), calendar.getDate().toString(), fRadio.isSelected() ? "F": "H");
        JDialog d = new JDialog();
        d.add(new Label("Patient ajouté"));
        d.setVisible(true);
    }
}
