package com.shirt.product_api.domain.catalog.shirt.model;

import com.shirt.product_api.domain.catalog.brand.model.Brand;
import com.shirt.product_api.domain.catalog.color.model.Color;
import com.shirt.product_api.domain.catalog.shirt.model.enums.ShirtMeasurement;
import com.shirt.product_api.domain.catalog.shirt.model.enums.details.Size;
import com.shirt.product_api.domain.image.model.Image;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "shirts")
@Getter
@Setter
@ToString
public class Shirt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @Embedded
    @Valid
    private ShirtMeasurement measurement;

    @Embedded
    @Valid
    private ShirtDetails details;

    @NotNull(message = "Price is required")
    @Enumerated(EnumType.STRING)
    private Size size;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Color color;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Brand brand;

    @Embedded
    @Valid
    private ShirtSaleDetails saleDetails;

    //TODO: Verificar se vou precisar usar FetchType.EAGER no campo das imagens na classe Shirt quando for buscar pelas camisetas
    @NotNull
    @OneToMany(orphanRemoval = true)
    @JoinTable(
            name = "shirt_image",
            joinColumns = @JoinColumn(name = "shirt_id"),
            inverseJoinColumns = @JoinColumn(name = "image_id")
    )
    private List<Image> imagesUrl;

    public Shirt() {
    }

    public Shirt(String name, ShirtMeasurement measurement, ShirtDetails details, Size size, Color color, Brand brand, ShirtSaleDetails saleDetails, List<Image> imagesUrl) {
        this.name = name;
        this.measurement = measurement;
        this.details = details;
        this.size = size;
        this.color = color;
        this.brand = brand;
        this.saleDetails = saleDetails;
        this.imagesUrl = imagesUrl;
    }
}
