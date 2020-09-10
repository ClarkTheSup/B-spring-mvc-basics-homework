package com.thoughtworks.capacity.gtb.mvc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(DuplicatedUsernameException.class)
    public ResponseEntity<ErrorMessage> duplicatedUsernameExceptionHandler(DuplicatedUsernameException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getErrorMessage());
    }

    @ExceptionHandler({MethodArgumentNotValidException.class, ConstraintViolationException.class})
    public ResponseEntity<ErrorMessage> validationExceptionHandler(Exception e) {
        String message = chooseErrorMessage(e.getMessage());
        ErrorMessage errorMessage = new ErrorMessage(message, 400);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
    }

    @ExceptionHandler(LoginException.class)
    public ResponseEntity<ErrorMessage> duplicatedUsernameExceptionHandler(LoginException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getErrorMessage());
    }

    public String chooseErrorMessage(String errorMessage) {
        if (errorMessage.indexOf("用户名不为空") >= 0) {
            return "用户名不为空";
        }
        if (errorMessage.indexOf("用户名不合法") >= 0) {
            return "用户名不合法";
        }
        if (errorMessage.indexOf("密码不合法") >= 0) {
            return "密码不合法";
        }
        if (errorMessage.indexOf("密码不为空") >= 0) {
            return "密码不为空";
        }
        if (errorMessage.indexOf("邮箱地址不合法") >= 0) {
            return "邮箱地址不合法";
        }
        return "";
    }
}
