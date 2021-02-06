package com.epam.tishkin;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

    Queue<String> parseString(String taskToSolve) {
        Queue<String> sequenceOfOperatorsAndNumbers = new LinkedList<>();
        Stack<String> stackForOperators = new Stack<>();
        String[] arrayOperatorsAndNumbers = taskToSolve.split(" ");
        for (String current : arrayOperatorsAndNumbers) {
            if (current.contains("sqrt")) {
                sequenceOfOperatorsAndNumbers.add(makeSquareRoot(current));
            }
            else if (isNumber(current)) {
                sequenceOfOperatorsAndNumbers.add(current);
            }
            else if (isOperator(current)) {
                while (!stackForOperators.isEmpty()
                        && getOperatorPriority(current) <= getOperatorPriority(stackForOperators.lastElement())) {
                    sequenceOfOperatorsAndNumbers.add(stackForOperators.pop());
                }
                stackForOperators.add(current);
            }
        }
        while (!stackForOperators.isEmpty()) {
            sequenceOfOperatorsAndNumbers.add(stackForOperators.pop());
        }
        return sequenceOfOperatorsAndNumbers;
    }

    public Double getCalculationResult(String taskToSolve) {
        Queue<String> sequenceOfOperatorsAndNumbers = parseString(taskToSolve);
        Stack<Double> stackForCalculationResult = new Stack<>();
        for (String current : sequenceOfOperatorsAndNumbers) {
            if (isNumber(current)) {
                stackForCalculationResult.add(Double.parseDouble(current));
            }
            else if (isOperator(current)) {
                double intermediateResult = 0;
                double secondMember = stackForCalculationResult.pop();
                double firstMember = stackForCalculationResult.pop();
                switch (current) {
                    case ("-"):
                        intermediateResult = makeSubtraction(firstMember, secondMember);
                        break;
                    case ("+"):
                        intermediateResult = makeAddition(firstMember, secondMember);
                        break;
                    case ("*"):
                        intermediateResult = makeMultiplication(firstMember, secondMember);
                        break;
                    case ("/"):
                        intermediateResult = makeDivision(firstMember, secondMember);
                        break;
                }
                stackForCalculationResult.add(intermediateResult);
            }
        }
        return stackForCalculationResult.pop();
    }
}
