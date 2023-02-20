package org.example.panel;

import lombok.Data;
import org.example.dto.ResponseProductDTO;
import org.example.service.ProductService;

import javax.swing.*;

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
    private JButton searchButton;

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
        searchButton.addActionListener((e) -> {
            responseProductDTO = productService.getById(Integer.valueOf(productIdTextField.getText()));
            if(responseProductDTO != null) {
                nameProductLabel.setText(responseProductDTO.getName());
                priceProductLabel.setText(String.valueOf(responseProductDTO.getPrice()));

            }
        });
    }
}
