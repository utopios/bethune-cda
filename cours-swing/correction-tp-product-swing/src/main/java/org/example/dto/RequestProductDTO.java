package org.example.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestProductDTO {
    private String name;
    private double price;
    private int stock;
}
