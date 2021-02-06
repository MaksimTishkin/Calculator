package com.epam.tishkin;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Calculator {
    private static final String OPERATORS = "+-*/";

    Double makeMultiplication(double  firstMultiplier, double secondMultiplier) {
        return firstMultiplier * secondMultiplier;
    }

    Double makeAddition(double firstTerm, double secondTerm) {
        return firstTerm + secondTerm;
    }

    Double makeSubtraction(double firstSubtrahend, double secondSubtrahend) {
        return firstSubtrahend - secondSubtrahend;
    }

    Double makeDivision(double divisible, double divider) {
        return divisible / divider;
    }

    String makeSquareRoot(String numberWithSquareRoot) {
        double number = 0;
        try {
            number = Double.parseDouble(numberWithSquareRoot.substring(4));
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException" + e.getMessage());
        }
        number = Math.sqrt(number);
        return Double.toString(number);
    }

    boolean isNumber(String stringForVerification) {
        try {
            double value = Double.parseDouble(stringForVerification);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    boolean isOperator(String stringForVerification) {
        return OPERATORS.contains(stringForVerification);
    }

    int getOperatorPriority(String operation) {
        if (operation.equals("-") || operation.equals("+")) {
            return 1;
        }
        return 2;
    }

}
