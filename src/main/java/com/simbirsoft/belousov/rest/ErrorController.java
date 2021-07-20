package com.simbirsoft.belousov.rest;

import com.simbirsoft.belousov.rest.exeption_handing.NoSuchExeption;
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
//    @ExceptionHandler(NoSuchExeption.class)
//    public ResponseEntity handleIOException(NoSuchExeption e) {
//        return new ResponseEntity(HttpStatus.NOT_FOUND);
//
//    }
}