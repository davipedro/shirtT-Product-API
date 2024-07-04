package com.shirt.product_api.domain.catalog.brand.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateBrandRequest(@NotBlank(message = "Name field is required") String name) {
}
