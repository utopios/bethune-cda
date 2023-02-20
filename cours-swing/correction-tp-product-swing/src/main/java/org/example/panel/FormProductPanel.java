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
    private JButton nextButton;
    private JButton previewButton;
    private JFrame _frame;
    private ProductService productService;
    private ResponseProductDTO responseProductDTO;
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
            if(responseProductDTO != null) {
                productIdTextField.setText(String.valueOf(responseProductDTO.getId()));
                nameTextField.setText(null);
                priceTextField.setText(null);
                stockTextField.setText(null);
            }

        });

        findButton.addActionListener((e) -> {
            responseProductDTO = productService.getById(Integer.valueOf(productIdTextField.getText()));
            if(responseProductDTO != null) {
                nameTextField.setText(responseProductDTO.getName());
                priceTextField.setText(String.valueOf(responseProductDTO.getPrice()));
                stockTextField.setText(String.valueOf(responseProductDTO.getStock()));
            }
        });

        updateButton.addActionListener((e) -> {
            if(responseProductDTO != null) {
                if(!stockTextField.getText().equals(String.valueOf(responseProductDTO.getStock()))) {
                    responseProductDTO = productService.patch(responseProductDTO.getId(), "stock", stockTextField.getText());
                }
            }
        });

        nextButton.addActionListener((e) -> {
            if(responseProductDTO != null) {
                responseProductDTO = productService.getById(responseProductDTO.getId() + 1);
                if(responseProductDTO != null) {
                    productIdTextField.setText(String.valueOf(responseProductDTO.getId()));
                    nameTextField.setText(responseProductDTO.getName());
                    priceTextField.setText(String.valueOf(responseProductDTO.getPrice()));
                    stockTextField.setText(String.valueOf(responseProductDTO.getStock()));
                }
            }
        });

        previewButton.addActionListener((e) -> {
            if(responseProductDTO != null) {
                responseProductDTO = productService.getById(responseProductDTO.getId() - 1);
                if(responseProductDTO != null) {
                    productIdTextField.setText(String.valueOf(responseProductDTO.getId()));
                    nameTextField.setText(responseProductDTO.getName());
                    priceTextField.setText(String.valueOf(responseProductDTO.getPrice()));
                    stockTextField.setText(String.valueOf(responseProductDTO.getStock()));
                }
            }
        });

    }

}
