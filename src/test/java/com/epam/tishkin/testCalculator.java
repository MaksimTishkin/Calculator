package com.epam.tishkin;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class testCalculator {
    private static Calculator calculator;
    private static double numberForTest;

    @BeforeAll
    static void initAll() {
        calculator = new Calculator();
        numberForTest = 5.6;
    }

    @Test
    public void testMultiplication() {
        double actualMultiplicationResult = calculator.makeMultiplication(8, numberForTest);
        Assertions.assertEquals(44.8, actualMultiplicationResult);
        actualMultiplicationResult = calculator.makeMultiplication(8.35, numberForTest);
        Assertions.assertEquals(46.76, actualMultiplicationResult);
        actualMultiplicationResult = calculator.makeMultiplication(0, numberForTest);
        Assertions.assertEquals(0, actualMultiplicationResult);
    }

    @Test
    public void testAddition() {
        double actualMultiplicationResult = calculator.makeAddition(6.4, numberForTest);
        Assertions.assertEquals(12, actualMultiplicationResult);
        actualMultiplicationResult = calculator.makeAddition(0, numberForTest);
        Assertions.assertEquals(numberForTest, actualMultiplicationResult);
        actualMultiplicationResult = calculator.makeAddition(12.9875, numberForTest);
        Assertions.assertEquals(18.5875, actualMultiplicationResult);
    }
}
