package com.thoughtworks.capacity.gtb.mvc.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(DuplicatedUsernameException.class)
    public ResponseEntity duplicatedUsernameExceptionHandler(DuplicatedUsernameException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getErrorMessage());
    }
}
