package com.epam.tishkin;

import com.epam.tishkin.exceptions.DivisionByZeroException;
import com.epam.tishkin.exceptions.IncorrectSourceDataException;

import java.util.List;
import java.util.Stack;

public class Calculator {
    private final ParserString parser = new ParserString();

    public Double getCalculationResult(String taskToSolve) throws DivisionByZeroException, IncorrectSourceDataException {
        List<String> listOfOperatorsAndNumbers = parser.parseString(taskToSolve);
        Stack<Double> stackForCalculationResult = new Stack<>();
        for (String current : listOfOperatorsAndNumbers) {
            if (parser.isNumber(current)) {
                stackForCalculationResult.add(Double.parseDouble(current));
            }
            else if (parser.isOperator(current)) {
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
                        if (secondMember == 0) {
                            throw new DivisionByZeroException("You can't divide by zero!");
                        }
                        intermediateResult = makeDivision(firstMember, secondMember);
                        break;
                }
                stackForCalculationResult.add(intermediateResult);
            }
        }
        return stackForCalculationResult.pop();
    }

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

    static String makeSquareRoot(String numberWithSquareRoot) {
        double number = 0;
        try {
            number = Double.parseDouble(numberWithSquareRoot.substring(4));
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException" + e.getMessage());
        }
        number = Math.sqrt(number);
        return Double.toString(number);
    }
}
