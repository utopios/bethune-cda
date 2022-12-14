package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JeuTest {

    private Jeu jeu;

    @BeforeEach
    void setUp() {
        jeu = new Jeu(new FauxDe());
    }

    @Test
    void testJouerWin() {
        Assertions.assertTrue(jeu.jouer());
    }
}
