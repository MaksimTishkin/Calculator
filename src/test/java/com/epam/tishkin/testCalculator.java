package com.epam.tishkin;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class testCalculator {
    private static Calculator calculator;
    private static double firstNumberForTest;
    private static double secondNumberForTest;
    private static String forIsNumberTestYes;
    private static String forIsNumberTestNo;
    private static String forSquareRootTest;

    @BeforeAll
    static void initAll() {
        calculator = new Calculator();
        firstNumberForTest = 4;
        secondNumberForTest = 8;
        forIsNumberTestYes = "25.5";
        forIsNumberTestNo = "+";
        forSquareRootTest = "sqrt64";
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
        double actualSubstractionResult = calculator.makeSubtraction(-firstNumberForTest, secondNumberForTest);
        Assertions.assertEquals(-12, actualSubstractionResult);
        actualSubstractionResult = calculator.makeSubtraction(firstNumberForTest, secondNumberForTest);
        Assertions.assertEquals(-4, actualSubstractionResult);
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
        String actualSquareRootOfNumber = calculator.makeSquareRoot(forSquareRootTest);
        String expectedSquareRootOfNumber = "8.0";
        Assertions.assertEquals(expectedSquareRootOfNumber, actualSquareRootOfNumber);
    }

    @Test
    public void testIsNumber() {
        Assertions.assertTrue(calculator.isNumber(forIsNumberTestYes));
        Assertions.assertFalse(calculator.isNumber(forIsNumberTestNo));
    }

    @Test
    public void testIsOperator() {
        Assertions.assertTrue(calculator.isOperator("+"));
        Assertions.assertFalse(calculator.isOperator("4"));
    }

    @Test
    public void testGetOperatorPriority() {
        Assertions.assertEquals(1, calculator.getOperatorPriority("-"));
        Assertions.assertEquals(2, calculator.getOperatorPriority("/"));
    }


}
