package com.shirt.product_api.domain.catalog.shirt.model;

import com.shirt.product_api.domain.catalog.shirt.model.enums.details.Fit;
import com.shirt.product_api.domain.catalog.shirt.model.enums.details.Neckline;
import com.shirt.product_api.domain.catalog.shirt.model.enums.details.Sleeve;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ShirtDetails {

        @NotNull(message = "Sleeve is required")
        @Enumerated(EnumType.STRING)
        private Sleeve sleeveType;

        @NotNull(message = "Neckline is required")
        @Enumerated(EnumType.STRING)
        private Neckline necklineType;

        @NotNull(message = "Fit is required")
        @Enumerated(EnumType.STRING)
        private Fit fitType;

        @NotBlank(message = "Extra details are required")
        private String otherDetails;
}
