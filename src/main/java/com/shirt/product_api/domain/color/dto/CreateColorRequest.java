package com.shirt.product_api.domain.color.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

//TODO: Caso de Teste: testar o regex
public record CreateColorRequest(
        @NotBlank
        String name,
        @NotNull
        @Pattern(regexp = "^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$")
        String hex) {
}