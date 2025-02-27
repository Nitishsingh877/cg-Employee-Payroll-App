package com.bridelabz.nitish.employeepayrollapp.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    private static final String message = "Exception while processing Rest request ";
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String,String>> httpMessageNotReadableException(HttpMessageNotReadableException e) {
        log.error("Invalid Date Format",e);
        Map<String,String> map = new HashMap<>();
        map.put("Please enter valid date", e.getMessage());
        return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
    }

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
