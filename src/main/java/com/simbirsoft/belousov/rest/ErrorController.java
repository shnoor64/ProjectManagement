package com.simbirsoft.belousov.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;

@ControllerAdvice
public class ErrorController {

//    @ExceptionHandler(IOException.class)
//    public ResponseEntity handleIOException(IOException e) {
//        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//    @ExceptionHandler(NotFoundException.class)
//    public ResponseEntity handleIOException(NotFoundException e) {
//        return new ResponseEntity(HttpStatus.NOT_FOUND);
//
//    }
    @ExceptionHandler(IOException.class)
    public ResponseEntity handleIOException(IOException e) {
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

}