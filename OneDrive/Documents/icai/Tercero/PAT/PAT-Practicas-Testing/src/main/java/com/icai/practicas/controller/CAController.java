package com.icai.practicas.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CAController extends ResponseEntityExceptionHandler {

    public static Logger logger = LoggerFactory.getLogger(CAController.class);

    record GlobalErrorResponse(String message) {}

    @ExceptionHandler({RuntimeException.class})
    protected ResponseEntity<Object> handleRuntimeException(RuntimeException ex, WebRequest request) {

        logger.error(ex.getLocalizedMessage(), ex);

        String message = "Contact with the operator";
        GlobalErrorResponse globalErrorResponse = new GlobalErrorResponse(message);
        return handleExceptionInternal(ex, globalErrorResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }
}