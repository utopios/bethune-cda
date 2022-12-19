package org.example;

import org.example.interfaces.IGenerateurBowling;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    @Test
    void Roll_SimpleFrame_SecondRoll_CheckScore() throws Exception {
        List<Roll> rolls = new ArrayList<>();
        rolls.add(new Roll(4));
        frame.setRolls(rolls);
        Mockito.when(generateurBowling.randomPin(6)).thenReturn(5);

        frame.makeRoll();

        Assertions.assertEquals(9, frame.getScore());
    }

    @Test
    void Roll_SimpleFrame_SecondRoll_FirstRollStrick_ReturnFalse() throws Exception {
        List<Roll> rolls = new ArrayList<>();
        rolls.add(new Roll(10));
        frame.setRolls(rolls);

        boolean res = frame.makeRoll();

        Assertions.assertFalse(res);
    }

    @Test
    void Roll_SimpleFrame_MoreRolls_ReturnFalse() throws Exception {
        List<Roll> rolls = new ArrayList<>();
        rolls.add(new Roll(4));
        rolls.add(new Roll(5));

        frame.setRolls(rolls);

        boolean res = frame.makeRoll();

        Assertions.assertFalse(res);
    }
}
