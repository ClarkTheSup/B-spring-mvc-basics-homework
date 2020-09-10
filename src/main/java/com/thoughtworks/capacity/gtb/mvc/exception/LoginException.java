package com.thoughtworks.capacity.gtb.mvc.exception;

import lombok.Data;

@Data
public class LoginException extends RuntimeException{
    private ErrorMessage errorMessage;

    public LoginException(String message, int errorCode) {
        this.errorMessage = new ErrorMessage(message, errorCode);
    }
}
