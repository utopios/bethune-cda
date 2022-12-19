package org.example;

import org.example.interfaces.IGenerateurBowling;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class FrameTest {

    private Frame frame;

    @Mock
    private IGenerateurBowling generateurBowling;

    @BeforeEach
    void setUp() {
        frame = new Frame(generateurBowling, false);
    }

    @Test
    void Roll_SimpleFrame_FirstRoll_CheckScore() throws Exception {
        Mockito.when(generateurBowling.randomPin(10)).thenReturn(6);
        frame.makeRoll();
        Assertions.assertEquals(6, frame.getScore());
    }
}
