package org.example.adapter;

import org.example.model.ProductCart;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class CartModel extends AbstractTableModel {
    private ArrayList<ProductCart> products;
    String header[] = new String[] {"Id", "Name", "Qty", "Price", "Total line"};

    public CartModel(ArrayList<ProductCart> l) {

        products = l;
    }
    @Override
    public int getRowCount() {

        return products.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ProductCart p = products.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return p.getId();
            case 1:
                return p.getName();
            case 2:
                return p.getQty();
            case 3:
                return p.getPrice();
            case 4:
                return p.getPrice()*p.getQty();
            default:
                return  null;
        }
    }

    public String getColumnName(int col) {
        return header[col];
    }
}