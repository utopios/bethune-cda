package org.example.panel;

import lombok.Data;
import org.example.dto.RequestProductDTO;
import org.example.dto.ResponseProductDTO;
import org.example.service.ProductService;

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
    private ProductService productService;
    public FormProductPanel(JFrame frame) {
        _frame = frame;
        productService = new ProductService();
        addEvent();
    }

    private void addEvent() {
        addButton.addActionListener((e) -> {
            RequestProductDTO productDTO = RequestProductDTO.builder()
                    .name(nameTextField.getText())
                    .price(Double.valueOf(priceTextField.getText()))
                    .stock(Integer.valueOf(stockTextField.getText()))
                    .build();
            ResponseProductDTO responseProductDTO = productService.add(productDTO);
            productIdTextField.setText(String.valueOf(responseProductDTO.getId()));
        });
    }

}
