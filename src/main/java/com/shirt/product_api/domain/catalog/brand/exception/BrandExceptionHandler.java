package com.shirt.product_api.domain.catalog.brand.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BrandExceptionHandler {

    private final String INVALID_REQUEST_BASE_MESSAGE = "Invalid brand: ";

    public ResponseEntity<String> handleBrandException(BrandException brandException){
        return ResponseEntity.badRequest().body(INVALID_REQUEST_BASE_MESSAGE + brandException.getMessage());
    }
}
