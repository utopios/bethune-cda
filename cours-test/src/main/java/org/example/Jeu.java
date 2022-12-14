package org.example;

import org.example.interfaces.IDe;

public class Jeu {

    private IDe _de;

    public Jeu(IDe de) {
        _de = de;
    }
    public boolean jouer() {
        if(_de.getValue() == 6) {
            return true;
        }
        return false;
     }
}
