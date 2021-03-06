package com.thoughtworks.capacity.gtb.mvc.exception;

import lombok.Data;

@Data
public class DuplicatedUsernameException extends RuntimeException{
    private ErrorMessage errorMessage;

    public DuplicatedUsernameException(String message, int errorCode) {
        this.errorMessage = new ErrorMessage(message, errorCode);
    }
}
