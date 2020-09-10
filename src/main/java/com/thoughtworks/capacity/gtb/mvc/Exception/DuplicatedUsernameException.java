package com.thoughtworks.capacity.gtb.mvc.Exception;

import lombok.Data;

@Data
public class DuplicatedUsernameException extends RuntimeException{
    private ErrorMessage errorMessage;

    public DuplicatedUsernameException(String message) {
        this.errorMessage = new ErrorMessage(message);
    }
}
