package org.example.model;

import lombok.Data;
import org.example.dto.ResponseProductDTO;

import java.util.ArrayList;
import java.util.List;

@Data
public class Cart {
    List<ProductCart> products;
    private double total;

    public Cart() {
        products = new ArrayList<>();
    }

    public boolean addToCart(ResponseProductDTO productDTO, int qty) {
        boolean exist = false;
        for(ProductCart p:products) {
            if(p.getId() == productDTO.getId()) {
                p.setQty(p.getQty()+qty);
                exist = true;
                break;
            }
        }
        if(!exist){
            return products.add(new ProductCart(productDTO.getId(),qty,productDTO.getPrice(), productDTO.getName()));
        }
        return exist;
    }
}
