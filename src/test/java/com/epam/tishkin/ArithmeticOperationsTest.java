package com.epam.tishkin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ArithmeticOperationsTest {
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
        double expectedMultiplicationResult = -32;
        Assertions.assertEquals(expectedMultiplicationResult, actualMultiplicationResult);
        expectedMultiplicationResult = 32;
        actualMultiplicationResult = calculator.makeMultiplication(firstNumberForTest, secondNumberForTest);
        Assertions.assertEquals(expectedMultiplicationResult, actualMultiplicationResult);
        expectedMultiplicationResult = 0;
        actualMultiplicationResult = calculator.makeMultiplication(0, firstNumberForTest);
        Assertions.assertEquals(expectedMultiplicationResult, actualMultiplicationResult);
        expectedMultiplicationResult = 32;
        actualMultiplicationResult = calculator.makeMultiplication(-firstNumberForTest, -secondNumberForTest);
        Assertions.assertEquals(expectedMultiplicationResult, actualMultiplicationResult);
    }

    @Test
    public void testAddition() {
        double actualAdditionResult = calculator.makeAddition(-firstNumberForTest, secondNumberForTest);
        double expectedAdditionResult = 4;
        Assertions.assertEquals(expectedAdditionResult, actualAdditionResult);
        actualAdditionResult = calculator.makeAddition(firstNumberForTest, secondNumberForTest);
        expectedAdditionResult = 12;
        Assertions.assertEquals(expectedAdditionResult, actualAdditionResult);
        actualAdditionResult = calculator.makeAddition(-firstNumberForTest, -secondNumberForTest);
        expectedAdditionResult = -12;
        Assertions.assertEquals(expectedAdditionResult, actualAdditionResult);
        actualAdditionResult = calculator.makeAddition(0, firstNumberForTest);
        Assertions.assertEquals(firstNumberForTest, actualAdditionResult);
    }

    @Test
    public void testSubtraction() {
        double actualSubstractionResult = calculator.makeSubtraction(-firstNumberForTest, secondNumberForTest);
        double expectedSubtractionResult = -12;
        Assertions.assertEquals(expectedSubtractionResult, actualSubstractionResult);
        actualSubstractionResult = calculator.makeSubtraction(firstNumberForTest, secondNumberForTest);
        expectedSubtractionResult = -4;
        Assertions.assertEquals(expectedSubtractionResult, actualSubstractionResult);
        actualSubstractionResult = calculator.makeSubtraction(firstNumberForTest, 0);
        expectedSubtractionResult = 4;
        Assertions.assertEquals(expectedSubtractionResult, actualSubstractionResult);
    }

    @Test
    public void testDivision() {
        double actualDevisionResult = calculator.makeDivision(-firstNumberForTest, secondNumberForTest);
        Assertions.assertEquals(-0.5, actualDevisionResult);
        actualDevisionResult = calculator.makeDivision(firstNumberForTest, secondNumberForTest);
        Assertions.assertEquals(0.5, actualDevisionResult);
        actualDevisionResult = calculator.makeDivision(0, firstNumberForTest);
        Assertions.assertEquals(0, actualDevisionResult);
    }

    @Test
    public void testSquareRoot() {
        String forSquareRootTest = "sqrt64";
        String actualSquareRootOfNumber = Calculator.makeSquareRoot(forSquareRootTest);
        String expectedSquareRootOfNumber = "8.0";
        Assertions.assertEquals(expectedSquareRootOfNumber, actualSquareRootOfNumber);
    }
}
