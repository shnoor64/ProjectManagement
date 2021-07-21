package com.simbirsoft.belousov.rest.exeption_handing;

public class NoSuchExeption extends RuntimeException {
    public NoSuchExeption (String message) {
        super(message);
    }
}
