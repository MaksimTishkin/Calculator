package com.epam.tishkin;

import com.epam.tishkin.exceptions.IncorrectSourceDataException;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class ParserString {
    private static final String OPERATORS = "+-*/";

    List<String> parseString(String taskToSolve) throws IncorrectSourceDataException {
        List<String> listOfOperatorsAndNumbers = new LinkedList<>();
        Stack<String> stackForOperators = new Stack<>();
        String[] arrayOperatorsAndNumbers = taskToSolve.split(" ");
        for (String current : arrayOperatorsAndNumbers) {
            if (current.contains("sqrt")) {
                listOfOperatorsAndNumbers.add(Calculator.makeSquareRoot(current));
            }
            else if (isNumber(current)) {
                listOfOperatorsAndNumbers.add(current);
            }
            else if (isOperator(current)) {
                while (!stackForOperators.isEmpty()
                        && getOperatorPriority(current) <= getOperatorPriority(stackForOperators.lastElement())) {
                    listOfOperatorsAndNumbers.add(stackForOperators.pop());
                }
                stackForOperators.add(current);
            }
            else {
                throw new IncorrectSourceDataException("Incorrect data entered - " + current);
            }
        }
        while (!stackForOperators.isEmpty()) {
            listOfOperatorsAndNumbers.add(stackForOperators.pop());
        }
        return listOfOperatorsAndNumbers;
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
