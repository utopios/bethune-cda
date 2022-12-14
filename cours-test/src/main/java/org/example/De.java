package org.example;

import org.example.interfaces.IDe;

import java.util.Random;

public class De implements IDe {
    Random random;
    public De() {
        random = new Random();
    }
    public int getValue() {
        //return (int)(Math.random() * 6) + 1;
        return random.nextInt(7);
    }
}
