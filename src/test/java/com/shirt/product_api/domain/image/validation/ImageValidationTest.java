package com.shirt.product_api.domain.image.validation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ImageValidationTest {
    @Test
    void shouldReturnTrueIfUrlIsValid() {
        //validar se o regex está correto
        String URL_REGEX = ImageValidation.URL_REGEX;
        assertTrue("https://www.google.com/test.png".matches(URL_REGEX));
    }
}