package com.simbirsoft.belousov.rest;

import com.simbirsoft.belousov.rest.exeption_handing.IncorrectlyEnteredStatusException;
import com.simbirsoft.belousov.rest.exeption_handing.NoSuchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;

@ControllerAdvice
public class ErrorController {

    @ExceptionHandler(IOException.class)
    public ResponseEntity<String> handleIOException(IOException e) {
        return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoSuchException.class)
    public ResponseEntity<String> handleIOException(NoSuchException e) {
        return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIOException(IllegalArgumentException e) {
        return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IncorrectlyEnteredStatusException.class)
    public ResponseEntity<String> handleIOException(IncorrectlyEnteredStatusException e) {
        return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}