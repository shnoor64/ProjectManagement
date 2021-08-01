package com.simbirsoft.belousov.rest;

import com.simbirsoft.belousov.rest.exeption_handing.NoSuchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;

@ControllerAdvice
public class ErrorController {

    @ExceptionHandler(IOException.class)
    public ResponseEntity handleIOException(IOException e) {
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoSuchException.class)
    public ResponseEntity handleIOException(NoSuchException e) {
        return new ResponseEntity(HttpStatus.NOT_FOUND);

    }
}