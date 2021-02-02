package com.epam.tishkin;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class testCalculator {

    Calculator calculator = new Calculator();

    @Test
    public void testMultiplication() {
        double expectedMultiplicationResult = calculator.makeMultiplication(5.6, 6.4);
        double actualMultiplicationResult = 5.6 * 6.4;
        Assertions.assertEquals(expectedMultiplicationResult, actualMultiplicationResult);
    }
}
