package org.example;

import org.example.interfaces.IDe;

public class FauxDeNotWin  implements IDe {
    @Override
    public int getValue() {
        return 3;
    }
}
