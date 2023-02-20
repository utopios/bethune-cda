package org.example.dto;

import lombok.Data;

@Data
public class ResponseProductDTO {
    private int id;
    private String name;
    private double price;
    private int stock;
}
