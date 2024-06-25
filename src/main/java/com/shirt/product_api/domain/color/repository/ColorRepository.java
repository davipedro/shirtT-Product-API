package com.shirt.product_api.domain.color.repository;

import com.shirt.product_api.domain.color.model.Color;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColorRepository extends JpaRepository<Color, Long> {

}
