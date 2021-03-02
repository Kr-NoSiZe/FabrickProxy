package com.fabrick.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;


public class FabrickException extends RuntimeException {

    @Getter
    @Setter
    private String code;

    @Getter
    @Setter
    private HttpStatus status;

    public FabrickException() {
        super();
    }

    public FabrickException(HttpStatus status, String code, String message) {
        super(message);
        this.code = code;
        this.status = status;
    }

    public FabrickException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }

    public FabrickException(String message) {
        super(message);
    }
}
