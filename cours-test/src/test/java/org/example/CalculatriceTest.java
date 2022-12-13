package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatriceTest {

    @Test
    void methodeTest1() {
        //A => Arange
        Calculatrice calculatrice = new Calculatrice();
        //A => Act
        int result = calculatrice.addition(10,30);
        //A => Assert
        Assertions.assertEquals(40,result);
    }

    @Test
    void methodeDivision1() throws Exception {
        Calculatrice  calculatrice = new Calculatrice();
        int result = calculatrice.division(10,2);
        Assertions.assertEquals(5,result);
    }

    @Test
    void methodeDivision2() {
        Calculatrice  calculatrice = new Calculatrice();
        Assertions.assertThrowsExactly(Exception.class, () -> {
            //Act
            calculatrice.division(10,0);
        });
    }
}
