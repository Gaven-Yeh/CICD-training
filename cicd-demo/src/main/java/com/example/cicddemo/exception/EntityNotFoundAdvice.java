package com.example.cicddemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class EntityNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(com.example.cicddemo.exception.EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String productNotFoundHandler(com.example.cicddemo.exception.EntityNotFoundException ex) {
        return ex.getMessage();
    }
}
