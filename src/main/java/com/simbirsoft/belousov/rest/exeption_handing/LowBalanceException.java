package com.simbirsoft.belousov.rest.exeption_handing;

public class LowBalanceException extends RuntimeException {
    public LowBalanceException(String message) {
        super(message);
    }
}
