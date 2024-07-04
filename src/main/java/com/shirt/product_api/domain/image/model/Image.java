package com.shirt.product_api.domain.image.model;

import com.shirt.product_api.domain.catalog.shirt.model.Shirt;
import com.shirt.product_api.domain.image.model.enums.ImageType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "images")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Image type is required")
    @Enumerated(EnumType.STRING)
    private ImageType type;

    @NotBlank(message = "URL is required")
    private String url;
}
