package com.shirt.product_api.domain.catalog.color.repository;

import com.shirt.product_api.domain.catalog.color.model.Color;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ColorRepository extends JpaRepository<Color, Long> {

    Optional<Color> findByFullName(String fullName);

    Optional<Color> findByMainColor(String mainColor);
}
