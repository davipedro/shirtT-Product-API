package com.shirt.product_api.domain.image.repository;

import com.shirt.product_api.domain.image.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long>{
}
