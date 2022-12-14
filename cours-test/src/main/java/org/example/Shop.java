package org.example;

import java.util.List;

public class Shop {
    private List<Product> products;

    public void update(Product product) throws Exception {
        product.setQuality(product.getQuality() - 1 );
        product.setSellIn(product.getSellIn() - 1);
    }
}