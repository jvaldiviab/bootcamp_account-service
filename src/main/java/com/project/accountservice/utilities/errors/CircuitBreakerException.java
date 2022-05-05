package com.project.accountservice.utilities.errors;

public class CircuitBreakerException extends Exception {

    public CircuitBreakerException(String s) {
        super(s);

    }
}