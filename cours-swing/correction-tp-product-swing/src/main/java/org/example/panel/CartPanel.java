package org.example.panel;

import com.sun.jdi.event.StepEvent;
import lombok.Data;
import org.example.adapter.CartModel;
import org.example.dto.ResponseProductDTO;
import org.example.model.Cart;
import org.example.model.ProductCart;
import org.example.service.ProductService;

import javax.swing.*;
import java.util.ArrayList;

@Data
public class CartPanel {
    private JPanel mainPanel;
    private JLabel productId;
    private JTextField productIdTextField;
    private JLabel nameProductLabel;
    private JLabel priceProductLabel;
    private JComboBox qtyComboBox;
    private JPanel buttonPanel;
    private JButton addButton;
    private JTable cartTable;
    private JButton searchButton;
    private JPanel tablePanel;

    private ResponseProductDTO responseProductDTO;
    private ProductService productService;
    private JFrame _frame;
    private Cart cart;
    private CartModel cartModel;
    public CartPanel(JFrame frame) {
        _frame = frame;

        productService = new ProductService();
        cart = new Cart();
        addEvent();
        cartModel = new CartModel((ArrayList<ProductCart>) cart.getProducts());
        cartTable = new JTable();
        cartTable.setModel(cartModel);
        tablePanel.add(new JScrollPane(cartTable));

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

        addButton.addActionListener((e) -> {
            if(responseProductDTO != null) {
                cart.addToCart(responseProductDTO, Integer.valueOf(qtyComboBox.getSelectedItem().toString()));
                cartModel.fireTableDataChanged();
            }
        });
    }

    private void createUIComponents() {
        String[] qtys = {"1","2","3", "4", "5"};
        qtyComboBox = new JComboBox(qtys);
    }
}
