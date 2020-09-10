package com.thoughtworks.capacity.gtb.mvc.Exception;

import lombok.Data;

@Data
public class ErrorMessage {
    private String message;
    public ErrorMessage(String message) {
        this.message = message;
    }
}
