package org.example;

import org.example.exception.NotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class RechercheVilleTest {

    private RechercheVille rechercheVille;

    @BeforeEach
    void setUp() {
        rechercheVille = new RechercheVille();
        rechercheVille.setVilles(Arrays.asList("Valence", "Vancouver","Amsterdam"));
    }

    //Q1
    @Test
    void rechercherShouldRaiseExceptionWhenMotIslessThen2chars() {
        Assertions.assertThrowsExactly(NotFoundException.class, () -> {
            rechercheVille.rechercher("a");
        });
    }

    //Q2
    @Test
    void rechercherShouldBeListWhenMotIsGT2Chars() throws Exception {
        //ACT
        List<String> villes = rechercheVille.rechercher("Va");

        //Assert
        Assertions.assertEquals(Arrays.asList("Valence", "Vancouver"), villes);
    }

    //Q3
    @Test
    void rechercherShouldNotBeCaseSenstive() throws Exception {
        List<String> villes = rechercheVille.rechercher("vA");

        //Assert
        Assertions.assertEquals(Arrays.asList("Valence", "Vancouver"), villes);
    }
}
