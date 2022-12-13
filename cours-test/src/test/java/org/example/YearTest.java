package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class YearTest {
    private Year year;
    @BeforeEach
    void setUp() {
        year = new Year();
    }

    @Test
    void testLeapShouldBeTrueWhenY2020() throws Exception {
        Assertions.assertTrue(year.isLeap(2020));
    }
    @Test
    void testLeapShouldBeFalseWhenY2021() throws Exception {
        Assertions.assertFalse(year.isLeap(2021));
    }

    @Test
    void testLeapShouldBeTrueWhenY2000() throws Exception {
        Assertions.assertTrue(year.isLeap(2000));
    }

    @Test
    void testLeapShouldBeTrueWhenY8000() throws Exception {
        Assertions.assertTrue(year.isLeap(8000));
    }
}
