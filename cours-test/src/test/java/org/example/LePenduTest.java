package org.example;

import org.example.exception.ErrorWordException;
import org.example.interfaces.IGenerateur;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class LePenduTest {
    private LePendu lePendu;

    @Mock
    private IGenerateur generateur;

    @BeforeEach
    void setUp() throws Exception {
        lePendu = new LePendu();
        Mockito.when(generateur.generer()).thenReturn("google");
        lePendu.genererMasque(generateur);
    }

    //region tests de la méthode genererMasque
    @Test
    void testGenererMasqueShouldBeCorrectMasque() throws Exception {
        //Arange
        Mockito.when(generateur.generer()).thenReturn("google");
        //Act
        lePendu.genererMasque(generateur);
        //Assert
        Assertions.assertEquals("******", lePendu.getMasque());
    }

    @Test
    void testGenererMasqueShouldRaiseExceptionIfNoChars() throws Exception {
        //Arange
        Mockito.when(generateur.generer()).thenReturn("");

        Assertions.assertThrowsExactly(ErrorWordException.class, () -> {
           lePendu.genererMasque(generateur);
        });
    }

    @Test
    void testGenererMasqueShouldRaiseExceptionIfWordIsNull() throws Exception {
        //Arange
        Mockito.when(generateur.generer()).thenReturn(null);

        Assertions.assertThrowsExactly(ErrorWordException.class, () -> {
            lePendu.genererMasque(generateur);
        });
    }

    //endregion

    //region tests de la méthode testChar
    @Test
    void testTestCharShouldBeTrueIfCorrectChar() throws Exception {
        //Act
        boolean res = lePendu.testChar('g');
        Assertions.assertTrue(res);
    }

    @Test
    void testTestCharShouldBeFalseIfNotCorrectChar() throws Exception {
        //Act
        boolean res = lePendu.testChar('a');
        Assertions.assertFalse(res);
    }

    @Test
    void testTestCharShouldBeUpdateNbEssaiIfNotCorrectChar() throws Exception {
        //Act
        int oldNbEssai = lePendu.getNbEssai();
        lePendu.testChar('a');
        int res = lePendu.getNbEssai();
        Assertions.assertEquals(oldNbEssai-1, res);
    }
    //endregion
}
