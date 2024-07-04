package com.shirt.product_api.domain.catalog.color.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "colors")
@Getter
@Setter
@NoArgsConstructor
public class Color {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Main color is required")
    @Column(name = "main_color")
    @Pattern(regexp = "^[a-zA-Z]*$", message = "Main color must contain only letters")
    private String mainColor;

    @NotBlank(message = "Color hex is required")
    @Column(nullable = false, unique = true)
    private String hex;

    @NotBlank(message = "Color full name is required")
    @Column(name = "full_name")
    private String fullName;

    public Color(String mainColor, String hex, String fullName) {
        this.mainColor = mainColor;
        this.hex = hex;
        this.fullName = fullName;
    }

}
