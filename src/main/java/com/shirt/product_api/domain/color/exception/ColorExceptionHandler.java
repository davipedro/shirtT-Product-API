package com.shirt.product_api.domain.color.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ColorExceptionHandler {
    private final String INVALID_REQUEST_BASE_MASSAGE = "Invalid color: ";

    @ExceptionHandler(ColorException.class)
    public ResponseEntity<String> handleColorException(ColorException e) {
        return ResponseEntity.badRequest().body(INVALID_REQUEST_BASE_MASSAGE + e.getMessage());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        return ResponseEntity.badRequest().body("Invalid request body");
    }
}
