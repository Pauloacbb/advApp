package com.api.advApp.controllers;

import com.api.advApp.exception.RecordNotfoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationControllerAdvice {
    @ExceptionHandler(RecordNotfoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNotFoundExcption(RecordNotfoundException ex){
        return ex.getMessage();
    }
}
