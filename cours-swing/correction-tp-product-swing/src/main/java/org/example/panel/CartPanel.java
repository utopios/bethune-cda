package org.example.panel;

import lombok.Data;
import org.example.dto.ResponseProductDTO;
import org.example.service.ProductService;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

@Data
public class CartPanel {
    private JPanel mainPanel;
    private JLabel productId;
    private JTextField productIdTextField;
    private JLabel nameProductLabel;
    private JLabel priceProductLabel;
    private JComboBox comboBox1;
    private JPanel buttonPanel;
    private JButton addButton;
    private JTable cartTable;

    private ResponseProductDTO responseProductDTO;
    private ProductService productService;
    private JFrame _frame;
    public CartPanel(JFrame frame) {
        _frame = frame;
        productService = new ProductService();
        addEvent();
    }

    private void addEvent() {
        productIdTextField.addActionListener((e) -> {
            System.out.println(productIdTextField.getText());
        });

    }
}
