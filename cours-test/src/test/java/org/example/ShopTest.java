package org.example;

import org.example.exception.QualityException;
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

    @Test
    void testUpdateShouldDecreaseQualityTwiceWhenSellInIs0() throws Exception {
        //A
        product = new Product("cat 1", "test", 0, 9);
        //Act
        shop.update(product);
        //Assert
        Assertions.assertEquals(4.5, product.getQuality());
    }

    @Test
    void testUpdateShouldRaiseExceptionWhenQualityIsNegative() throws Exception {
        //A
        product = new Product("cat 1", "test", 0, -9);
        Assertions.assertThrowsExactly(QualityException.class, () -> {
            shop.update(product);
        });
    }
}
