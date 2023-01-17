package com.example.productapp.dto.request;

import lombok.Data;

@Data
public class RequestProductDTO {
    private String name;
    private double price;
    private int stock;
}
