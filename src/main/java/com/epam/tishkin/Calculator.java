package com.epam.tishkin;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Calculator {

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

    Double makeSquareRoot(double number) {
        double squareRoot = 0.5;
        return number * squareRoot;
    }

    static boolean isNumber(String StringForVerification) {
        try {
            double value = Double.parseDouble(StringForVerification);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
