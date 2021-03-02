package com.fabrick.controller;

import com.fabrick.exception.ErrorHolder;
import com.fabrick.exception.FabrickException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler (value = { FabrickException.class })
    protected ResponseEntity<Object> handleConflict(FabrickException ex, WebRequest request) {
        ErrorHolder error = new ErrorHolder(ex.getCode(), ex.getMessage());
        return handleExceptionInternal(ex, error, new HttpHeaders(), ex.getStatus(), request);
    }
}