package com.epam.tishkin;

import com.epam.tishkin.exceptions.IncorrectSourceDataException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ParseAndCalculationTest {
    private static Calculator calculator;
    private static ParserString parser;

    @BeforeAll
    static void initAll() {
        calculator = new Calculator();
        parser = new ParserString();
    }

    @Test
    public void testParseString() throws IncorrectSourceDataException {
        String inputString = "2 + 3 * 45.3 * 90 + 20 - 8 / 20 - sqrt4";
        List<String> expectedList = Arrays.asList("2", "3", "45.3", "*", "90", "*", "+",
                "20", "+", "8", "20", "/", "-", "2.0", "-");
        List<String> actualList = parser.parseString(inputString);
        Assertions.assertEquals(expectedList, actualList);
    }

    @Test
    public void testCalculationResult() throws IncorrectSourceDataException {
        double expectedCalculationResult = 12250.6;
        double actualCalculationResult = calculator.getCalculationResult("2 + 3 * 45.3 * 90 + 20 - 8 / 20 - sqrt4");
        Assertions.assertEquals(expectedCalculationResult, actualCalculationResult);
    }
}
