package com.epam.tishkin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ParseAndCalculationTest {
    private static Calculator calculator;

    @BeforeAll
    static void initAll() {
        calculator = new Calculator();
    }

    @Test
    public void testParseString() throws IncorrectSourceDataException {
        String inputString = "2 + 3 * sqrt16";
        List<String> parseString = Arrays.asList("2", "3", "4.0", "*", "+");
        Queue<String> expectedQueue = new LinkedList<>(parseString);
        Queue<String> actualQueue = calculator.parseString(inputString);
        Assertions.assertEquals(expectedQueue, actualQueue);
    }

    @Test
    public void testCalculationResult() throws IncorrectSourceDataException {
        double expectedCalculationResult = 14;
        double actualCalculationResult = calculator.getCalculationResult("2 + 3 * sqrt16");
        Assertions.assertEquals(expectedCalculationResult, actualCalculationResult);
    }
}
