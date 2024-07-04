package com.shirt.product_api.domain.catalog.shirt.model.enums;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ShirtMeasurement {

    @NotNull(message = "Sleeve size is required")
    @Column(name = "sleeve_measure")
    private Integer sleeve;
    @NotNull(message = "Length size is required")
    @Column(name = "length_measure")
    private Integer length;
    @NotNull(message = "Width size is required")
    @Column(name = "width_measure")
    private Integer width;
}
