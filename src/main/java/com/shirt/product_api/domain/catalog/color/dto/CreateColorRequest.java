package com.shirt.product_api.domain.catalog.color.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

//TODO: Caso de Teste: testar o regex
public record CreateColorRequest(
        @NotBlank(message = "Main color is required")
        @JsonAlias("main_color")
        String mainColor,
        @NotBlank(message = "Full name is required, if is a base color use 'base'")
        @JsonAlias("full_name")
        String fullName,
        @NotNull(message = "Hex is required")
        @Pattern(regexp = "^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$")
        String hex) {
}