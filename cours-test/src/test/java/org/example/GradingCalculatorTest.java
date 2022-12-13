package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GradingCalculatorTest {

    private GradingCalculator gradingCalculator;

    private char arangeAndAct(int s, int a) {
        gradingCalculator.setScore(s);
        gradingCalculator.setAttendancePercentage(a);
        return gradingCalculator.getGrade();
    }


    @BeforeEach
    void setUp() {
        gradingCalculator = new GradingCalculator();
    }

    //GivenWhenThen
    @Test
    void testGetGradeWithScore_95_andAttendance_90TheResultShouldBe_A() {
        //Arange
        gradingCalculator.setScore(95);
        gradingCalculator.setAttendancePercentage(90);
        //Act
        char res = gradingCalculator.getGrade();
        //Assert
        Assertions.assertEquals('A', res);
    }

    //ShouldWhen
    @Test
    void testGetGradeShouldBeBWhenScore85AndAttendance90() {
        //Arange
        gradingCalculator.setScore(85);
        gradingCalculator.setAttendancePercentage(90);
        //Act
        char res = gradingCalculator.getGrade();
        //Assert
        Assertions.assertEquals('B', res);
    }

    @Test
    void testGetGradeShouldBeBWhenScore65AndAttendance90() {
        char res = arangeAndAct(65,90);
        //Assert
        Assertions.assertEquals('C', res);
    }
}
