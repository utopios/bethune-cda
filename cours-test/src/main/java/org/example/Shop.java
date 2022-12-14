package org.example;

import org.example.exception.QualityException;

import java.util.List;

public class Shop {
    private List<Product> products;

    public void update(Product product) throws Exception {
        if(product.getQuality() <= 0) {
            throw new QualityException();
        }
        if(product.getSellIn() == 0) {
            product.setQuality(product.getQuality() / 2);
        }
        else {
            product.setQuality(product.getQuality() - 1 );
            product.setSellIn(product.getSellIn() - 1);
        }

    }
}