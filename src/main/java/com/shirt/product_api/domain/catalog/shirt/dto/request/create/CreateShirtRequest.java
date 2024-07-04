package com.shirt.product_api.domain.catalog.shirt.dto.request.create;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.shirt.product_api.domain.catalog.shirt.model.ShirtDetails;
import com.shirt.product_api.domain.catalog.shirt.model.ShirtSaleDetails;
import com.shirt.product_api.domain.catalog.shirt.model.enums.ShirtMeasurement;
import com.shirt.product_api.domain.catalog.shirt.model.enums.details.Size;
import com.shirt.product_api.domain.image.model.Image;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.ToString;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CreateShirtRequest(
        @NotBlank(message = "Name is required")
        String name,

        @NotNull(message = "Measurement is required")
        @Valid
        ShirtMeasurement measurement,

        @NotNull(message = "Details are required")
        @Valid
        ShirtDetails details,

        @NotNull(message = "Size is required")
        Size size,

        @NotNull(message = "Color ID is required")
        Long colorId,

        @NotNull(message = "Brand ID is required")
        Long brandId,

        @NotNull(message = "Sale details are required")
        @Valid
        ShirtSaleDetails saleDetails,

        @NotNull(message = "Image are required")
        List<Image> images
) {}