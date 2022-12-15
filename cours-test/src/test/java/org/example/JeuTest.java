package org.example;

import org.example.interfaces.IDe;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class JeuTest {

    private Jeu jeu;

    @Mock
    private IDe de;
    @BeforeEach
    void setUp() {
        //Methode 1
        //jeu = new Jeu(new FauxDe());
        //Methode 2
        /*jeu = new Jeu(new IDe() {
            @Override
            public int getValue() {
                return 6;
            }
        });*/
        //Methode 3
        jeu  = new Jeu(de);
        Mockito.when(de.getValue()).thenReturn(6);
    }

    @Test
    void testJouerWin() {
        Assertions.assertTrue(jeu.jouer());
    }

    @Test
    void testJouerNotWin() {
        /*jeu = new Jeu(new IDe() {
            @Override
            public int getValue() {
                return 0;
            }
        });*/
        Mockito.when(de.getValue()).thenReturn(3);
        Assertions.assertFalse(jeu.jouer());
    }
}
