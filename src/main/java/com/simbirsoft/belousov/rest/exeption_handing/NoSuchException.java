package com.simbirsoft.belousov.rest.exeption_handing;

public class NoSuchException extends RuntimeException {
    public NoSuchException (String message) {
        super(message);
    }
}
