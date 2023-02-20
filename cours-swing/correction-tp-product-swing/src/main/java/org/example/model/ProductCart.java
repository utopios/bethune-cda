package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductCart {
    private int id;
    private int qty;
    private double price;
    private String name;
}
