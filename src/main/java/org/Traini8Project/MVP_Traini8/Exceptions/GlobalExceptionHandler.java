package org.Traini8Project.MVP_Traini8.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

// Global Exception handler class to handle all the exceptions in our application
@RestControllerAdvice
public class GlobalExceptionHandler {

//    Method to handle MethodArgumentNotValidException exception i.e. exceptions raised
//    by the validators in our entity class( Center.java )
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleMethodArgNotValidException(MethodArgumentNotValidException ex){
        Map<String, String> resMap = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error)->{
            String field = ((FieldError)error).getField();
            String msg = error.getDefaultMessage();
            resMap.put(field, msg);
        });
        return new ResponseEntity<>(resMap, HttpStatus.BAD_REQUEST);
    }
}
