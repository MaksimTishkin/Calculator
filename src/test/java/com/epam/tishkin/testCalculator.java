package com.epam.tishkin;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class testCalculator {
    private static Calculator calculator;
    private static double firstNumberForTest;
    private static double secondNumberForTest;

    @BeforeAll
    static void initAll() {
        calculator = new Calculator();
        firstNumberForTest = 4;
        secondNumberForTest = 8;
    }

    @Test
    public void testMultiplication() {
        double actualMultiplicationResult = calculator.makeMultiplication(-firstNumberForTest, secondNumberForTest);
        Assertions.assertEquals(-32, actualMultiplicationResult);
        actualMultiplicationResult = calculator.makeMultiplication(firstNumberForTest, secondNumberForTest);
        Assertions.assertEquals(32, actualMultiplicationResult);
        actualMultiplicationResult = calculator.makeMultiplication(0, firstNumberForTest);
        Assertions.assertEquals(0, actualMultiplicationResult);
    }

    @Test
    public void testAddition() {
        double actualMultiplicationResult = calculator.makeAddition(-firstNumberForTest, secondNumberForTest);
        Assertions.assertEquals(4, actualMultiplicationResult);
        actualMultiplicationResult = calculator.makeAddition(firstNumberForTest, secondNumberForTest);
        Assertions.assertEquals(12, actualMultiplicationResult);
        actualMultiplicationResult = calculator.makeAddition(0, firstNumberForTest);
        Assertions.assertEquals(firstNumberForTest, actualMultiplicationResult);
    }

    @Test
    public void testSubtraction() {
        double actualSubstractionResult = calculator.makeSubtraction(firstNumberForTest, secondNumberForTest);
        Assertions.assertEquals(0.5, actualSubstractionResult);
        actualSubstractionResult = calculator.makeSubtraction(-firstNumberForTest, secondNumberForTest);
        Assertions.assertEquals(-0.5, actualSubstractionResult);
        actualSubstractionResult = calculator.makeSubtraction(0, firstNumberForTest);
        Assertions.assertEquals(0, actualSubstractionResult);
    }
}
