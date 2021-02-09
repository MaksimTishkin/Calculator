package com.epam.tishkin.exceptions;

public class DivisionByZeroException extends ArithmeticException {
    public DivisionByZeroException (String message) {
        super(message);
    }
}
