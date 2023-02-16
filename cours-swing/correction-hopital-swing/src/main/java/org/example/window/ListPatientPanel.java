package org.example.window;

import com.example.tphopital.entity.Patient;
import com.example.tphopital.repository.impl.PatientRepository;
import com.example.tphopital.service.PatientService;
import lombok.Data;
import org.example.adapter.PatientModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

@Data
public class ListPatientPanel {
    private JPanel mainPanel;
    private JTable jTable;
    private JFrame _frame;
    private PatientService patientService;
    public  ListPatientPanel(JFrame frame) {
        _frame = frame;
        mainPanel.setLayout(new GridLayout());
        patientService = new PatientService(new PatientRepository());
        jTable = new JTable();

        ArrayList<Patient> patients = (ArrayList<Patient>) patientService.getAll();
        PatientModel model = new PatientModel(patients);
        jTable.setModel(model);

        mainPanel.add( new JScrollPane(jTable));
    }
}
