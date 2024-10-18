package com.validation.demo.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InputException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(InputException ex) {
        Map<String, String> errors = new HashMap<>();
        
            String errorMessage = ex.getMessage();
            errors.put("Error", errorMessage);
        
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
