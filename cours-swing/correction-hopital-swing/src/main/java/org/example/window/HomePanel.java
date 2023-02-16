package org.example.window;

import lombok.Data;

import javax.swing.*;

@Data
public class HomePanel {
    private JPanel mainPanel;
    private JButton formPatientButton;
    private JButton listPatientButton;
    private JFrame _frame;

    public HomePanel(JFrame frame) {
        _frame = frame;
        formPatientButton.addActionListener((e) -> {
            _frame.setContentPane(new FormPatientPanel(frame).getMainPanel());
            _frame.revalidate();
        });
    }
}
