package com.shirt.product_api.domain.catalog.color.service;

import com.shirt.product_api.domain.catalog.color.dto.CreateColorRequest;
import com.shirt.product_api.domain.catalog.color.model.Color;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
class ColorServiceIntegrationTest {

    @Autowired
    private ColorService colorService;

    @Test
    void saveColor() {
        // arrange
        CreateColorRequest colorRequest = new CreateColorRequest("Azul", "Azul Marinho", "#0000FF");

        // act
        Color savedColor = colorService.saveColor(colorRequest);

        // assert
        assertNotNull(savedColor.getId());  // O ID deve ser gerado automaticamente pelo banco de dados
        System.out.println(savedColor.getId());
    }
}