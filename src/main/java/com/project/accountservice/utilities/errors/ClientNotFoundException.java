package com.project.accountservice.utilities.errors;


public class ClientNotFoundException extends RuntimeException {
    public ClientNotFoundException(String s) {
        super(s);
    }
}