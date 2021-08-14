package com.simbirsoft.belousov.rest.exeption_handing;

public class IncorrectlyEnteredStatusException extends RuntimeException{

    public IncorrectlyEnteredStatusException(String message) {
        super(message);
    }
}
