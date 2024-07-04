package com.shirt.product_api.domain.catalog.shirt.model.mapper;

import com.shirt.product_api.domain.catalog.brand.model.Brand;
import com.shirt.product_api.domain.catalog.color.model.Color;
import com.shirt.product_api.domain.catalog.shirt.dto.request.create.CreateShirtRequest;
import com.shirt.product_api.domain.catalog.shirt.model.Shirt;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShirtMapper {
    public Shirt ShirtRequestToShirt(CreateShirtRequest createShirtRequest, Color color, Brand brand){
        return new Shirt(
                createShirtRequest.name(),
                createShirtRequest.measurement(),
                createShirtRequest.details(),
                createShirtRequest.size(),
                color,
                brand,
                createShirtRequest.saleDetails(),
                createShirtRequest.images()
        );
    }
}
