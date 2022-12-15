package org.example;

import org.example.interfaces.IGenerateur;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class LePenduTest {
    private LePendu lePendu;

    @Mock
    private IGenerateur generateur;

    @BeforeEach
    void setUp() {
        lePendu = new LePendu();
    }

    @Test
    void testGenererMasqueShouldBeCorrectMasque() throws Exception {
        //Arange
        Mockito.when(generateur.generer()).thenReturn("google");
        //Act
        lePendu.genererMasque(generateur);
        //Assert
        Assertions.assertEquals("******", lePendu.getMasque());
    }
}
