package org.example.adapter;

import com.example.tphopital.entity.Patient;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class PatientModel extends AbstractTableModel {
    private ArrayList<Patient> patients;
    String header[] = new String[] {"nom", "prenom", "code", "adresse"};

    public PatientModel(ArrayList<Patient> l) {
        patients = l;
    }
    @Override
    public int getRowCount() {
        return patients.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Patient p = patients.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return p.getNom();
            case 1:
                return p.getPrenom();
            case 2:
                return p.getNss();
            case 3:
                return p.getAdresse();
            default:
                return  null;
        }
    }

    public String getColumnName(int col) {
        return header[col];
    }
}
