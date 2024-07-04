package com.shirt.product_api.domain.catalog.shirt.repository;

import com.shirt.product_api.domain.catalog.shirt.model.Shirt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ShirtRepository extends JpaRepository<Shirt, Long> {
}
