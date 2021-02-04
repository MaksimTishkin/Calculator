package com.epam.tishkin;

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

    Double makeDevision(double divisible, double divider) {
        return divisible / divider;
    }

    public static void main( String[] args ) {
    }
}
