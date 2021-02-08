package com.epam.tishkin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class OperatorsAndNumbersVerificationTest {
    private static Calculator calculator;

    @BeforeAll
    static void initAll() {
        calculator = new Calculator();
    }

    @Test
    public void testIsNumber() {
        String forIsNumberTestYes = "25.5";
        String forIsNumberTestNo = "+";
        Assertions.assertTrue(calculator.isNumber(forIsNumberTestYes));
        Assertions.assertFalse(calculator.isNumber(forIsNumberTestNo));
    }

    @Test
    public void testIsOperator() {
        Assertions.assertTrue(calculator.isOperator("+"));
        Assertions.assertFalse(calculator.isOperator("4"));
    }

    @Test
    public void testOperatorPriority() {
        Assertions.assertEquals(1, calculator.getOperatorPriority("-"));
        Assertions.assertEquals(2, calculator.getOperatorPriority("/"));
    }
}
