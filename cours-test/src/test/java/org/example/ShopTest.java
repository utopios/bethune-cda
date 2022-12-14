package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ShopTest {
    private Shop shop;
    private Product product;

    @BeforeEach
    void setUp() {
        shop = new Shop();
    }

    @Test
    void testUpdateShouldDecreaseQuality() throws Exception {
        //A
        product = new Product("cat 1", "test", 10, 10);
        //Act
        shop.update(product);
        //Assert
        Assertions.assertEquals(9, product.getQuality());
    }

    @Test
    void testUpdateShouldDecreaseSellIn() throws Exception {
        //A
        product = new Product("cat 1", "test", 10, 10);
        //Act
        shop.update(product);
        //Assert
        Assertions.assertEquals(9, product.getSellIn());
    }
}
