package com.epam.tishkin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ArithmeticOperationsTest {
    private static Calculator calculator;
    private static double firstNumberForTest;
    private static double secondNumberForTest;
    private static double actualOperationsResult;
    private static double expectedOperationsResult;

    @BeforeAll
    static void initAll() {
        calculator = new Calculator();
        firstNumberForTest = 4;
        secondNumberForTest = 8;
    }

    @Test
    public void testMultiplication() {
        actualOperationsResult = calculator.makeMultiplication(-firstNumberForTest, secondNumberForTest);
        expectedOperationsResult = -32;
        Assertions.assertEquals(expectedOperationsResult, actualOperationsResult);
        expectedOperationsResult = 32;
        actualOperationsResult = calculator.makeMultiplication(firstNumberForTest, secondNumberForTest);
        Assertions.assertEquals(expectedOperationsResult, actualOperationsResult);
        expectedOperationsResult = 0;
        actualOperationsResult = calculator.makeMultiplication(0, firstNumberForTest);
        Assertions.assertEquals(expectedOperationsResult, actualOperationsResult);
        expectedOperationsResult = 32;
        actualOperationsResult = calculator.makeMultiplication(-firstNumberForTest, -secondNumberForTest);
        Assertions.assertEquals(expectedOperationsResult, actualOperationsResult);
    }

    @Test
    public void testAddition() {
        actualOperationsResult = calculator.makeAddition(-firstNumberForTest, secondNumberForTest);
        expectedOperationsResult = 4;
        Assertions.assertEquals(expectedOperationsResult, actualOperationsResult);
        actualOperationsResult = calculator.makeAddition(firstNumberForTest, secondNumberForTest);
        expectedOperationsResult = 12;
        Assertions.assertEquals(expectedOperationsResult, actualOperationsResult);
        actualOperationsResult = calculator.makeAddition(-firstNumberForTest, -secondNumberForTest);
        expectedOperationsResult = -12;
        Assertions.assertEquals(expectedOperationsResult, actualOperationsResult);
        actualOperationsResult = calculator.makeAddition(0, firstNumberForTest);
        Assertions.assertEquals(firstNumberForTest, actualOperationsResult);
    }

    @Test
    public void testSubtraction() {
        actualOperationsResult = calculator.makeSubtraction(-firstNumberForTest, secondNumberForTest);
        expectedOperationsResult = -12;
        Assertions.assertEquals(expectedOperationsResult, actualOperationsResult);
        actualOperationsResult = calculator.makeSubtraction(firstNumberForTest, secondNumberForTest);
        expectedOperationsResult = -4;
        Assertions.assertEquals(expectedOperationsResult, actualOperationsResult);
        actualOperationsResult = calculator.makeSubtraction(firstNumberForTest, 0);
        expectedOperationsResult = 4;
        Assertions.assertEquals(expectedOperationsResult, actualOperationsResult);
    }

    @Test
    public void testDivision() {
        actualOperationsResult = calculator.makeDivision(-firstNumberForTest, secondNumberForTest);
        expectedOperationsResult = -0.5;
        Assertions.assertEquals(expectedOperationsResult, actualOperationsResult);
        actualOperationsResult = calculator.makeDivision(firstNumberForTest, secondNumberForTest);
        expectedOperationsResult = 0.5;
        Assertions.assertEquals(expectedOperationsResult, actualOperationsResult);
        actualOperationsResult = calculator.makeDivision(0, firstNumberForTest);
        expectedOperationsResult = 0;
        Assertions.assertEquals(expectedOperationsResult, actualOperationsResult);
    }

    @Test
    public void testSquareRoot() {
        String inputStringWihSquareRoot = "sqrt64";
        String actualSquareRootOfNumber = Calculator.makeSquareRoot(inputStringWihSquareRoot);
        String expectedSquareRootOfNumber = "8.0";
        Assertions.assertEquals(expectedSquareRootOfNumber, actualSquareRootOfNumber);
    }
}
