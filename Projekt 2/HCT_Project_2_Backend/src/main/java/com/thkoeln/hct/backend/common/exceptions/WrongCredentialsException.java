package com.thkoeln.hct.backend.common.exceptions;

public class WrongCredentialsException extends Exception {

    public WrongCredentialsException() {
        super();
    }

    public WrongCredentialsException(String message) {
        super(message);
    }

}
