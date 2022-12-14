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

    @Test
    void testUpdateShouldRaiseExceptionWhenQualityIsMoreThen50() throws Exception {
        //A
        product = new Product("cat 1", "test", 0, 50);
        Assertions.assertThrowsExactly(QualityException.class, () -> {
            shop.update(product);
        });
    }

    @Test
    void testUpdateShouldIncreaseQualityWhenProductIsBrie() throws Exception {
        //A
        product = new Product("laitier", "brie vieilli", 10, 10);
        shop.update(product);
        Assertions.assertEquals(11, product.getQuality());
    }

    @Test
    void testUpdateShouldDecreaseQualityTwiceWhenTypeIsLaitier() throws Exception {
        //A
        product = new Product("laitier", "yaourt", 10, 10);
        shop.update(product);
        Assertions.assertEquals(5, product.getQuality());
    }
}
