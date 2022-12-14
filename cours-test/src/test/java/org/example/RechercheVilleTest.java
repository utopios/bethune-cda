package org.example;

import org.example.exception.NotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

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
}
