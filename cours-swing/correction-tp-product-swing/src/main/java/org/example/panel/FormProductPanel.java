package org.example.panel;

import lombok.Data;

import javax.swing.*;

@Data
public class FormProductPanel {
    private JPanel mainPanel;
    private JTextField productIdTextField;
    private JTextField nameTextField;
    private JTextField priceTextField;
    private JTextField stockTextField;
    private JPanel buttonPanel;
    private JButton addButton;
    private JButton updateButton;
    private JButton findButton;
    private JFrame _frame;

    public FormProductPanel(JFrame frame) {
        _frame = frame;
    }


}
