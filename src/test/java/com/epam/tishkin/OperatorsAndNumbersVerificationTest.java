package com.epam.tishkin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class OperatorsAndNumbersVerificationTest {
    private static ParserString parser;

    @BeforeAll
    static void initAll() {
        parser = new ParserString();
    }

    @Test
    public void testIsNumber() {
        String validValue = "25.5";
        String invalidValue = "+";
        Assertions.assertTrue(parser.isNumber(validValue));
        Assertions.assertFalse(parser.isNumber(invalidValue));
    }

    @Test
    public void testIsOperator() {
        Assertions.assertTrue(parser.isOperator("+"));
        Assertions.assertFalse(parser.isOperator("4"));
    }

    @Test
    public void testOperatorPriority() {
        int prioriryForSubtractionAndAddition = 1;
        int priorityForMultiplicationAndDivision = 2;
        Assertions.assertEquals(prioriryForSubtractionAndAddition, parser.getOperatorPriority("-"));
        Assertions.assertEquals(priorityForMultiplicationAndDivision, parser.getOperatorPriority("/"));
    }
}
