package com.project.accountservice.utilities.errors;

public class CreditCardException extends RuntimeException {
    public CreditCardException(String s) {
        super(s);
    }
}