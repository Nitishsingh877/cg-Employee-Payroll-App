package com.bridelabz.nitish.employeepayrollapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        Map<String,String> response = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
          String field =  ((FieldError) error).getField();
          String message = error.getDefaultMessage();
          response.put(field,message);

        });
        return new ResponseEntity<Map<String,String >>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Map<String,String>> handleNoSuchElementException(NoSuchElementException ex) {
        Map<String,String> response = new HashMap<>();
        response.put("Id is in not found in database",ex.getMessage());
        return new ResponseEntity<Map<String,String>>(response, HttpStatus.NOT_FOUND);
    }
}
