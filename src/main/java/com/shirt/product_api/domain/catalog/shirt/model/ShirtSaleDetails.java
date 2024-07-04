package com.shirt.product_api.domain.catalog.shirt.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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
public class ShirtSaleDetails {
    @NotNull(message = "On sale is required")
    private boolean onSale;
    @NotNull(message = "Quantity is required")
    private Integer quantity;
    @NotNull(message = "Price is required")
    private Double price;
    @Min(value = 0, message = "Discount percentage must be greater than 0")
    @Max(value = 100, message = "Discount percentage must be less than 100")
    @JsonAlias("discount_percentage")
    private Integer discountPercentage;
    @Min(value = 0, message = "Cashback percentage must be greater than 0")
    @Max(value = 100, message = "Cashback percentage must be less than 100")
    @JsonAlias("cashback_percentage")
    private Integer cashbackPercentage;
}
