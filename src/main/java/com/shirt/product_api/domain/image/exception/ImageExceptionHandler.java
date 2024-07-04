package com.shirt.product_api.domain.image.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ImageExceptionHandler {

    private static final String INVALID_REQUEST_BASE_MASSAGE = "Invalid image: ";

    @ExceptionHandler(ImageValidationException.class)
    public ResponseEntity<String> handleImageValidationException(ImageValidationException e) {

        return ResponseEntity.badRequest().body(INVALID_REQUEST_BASE_MASSAGE + e.getMessage());
    }
}
