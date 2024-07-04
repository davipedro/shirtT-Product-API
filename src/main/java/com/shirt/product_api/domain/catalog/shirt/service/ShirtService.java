package com.shirt.product_api.domain.catalog.shirt.service;

import com.shirt.product_api.domain.catalog.brand.model.Brand;
import com.shirt.product_api.domain.catalog.brand.repository.BrandRepository;
import com.shirt.product_api.domain.catalog.color.exception.ColorException;
import com.shirt.product_api.domain.catalog.color.model.Color;
import com.shirt.product_api.domain.catalog.color.repository.ColorRepository;
import com.shirt.product_api.domain.catalog.shirt.dto.request.create.CreateShirtRequest;
import com.shirt.product_api.domain.catalog.shirt.model.Shirt;
import com.shirt.product_api.domain.catalog.shirt.model.mapper.ShirtMapper;
import com.shirt.product_api.domain.catalog.shirt.repository.ShirtRepository;
import com.shirt.product_api.domain.image.repository.ImageRepository;
import com.shirt.product_api.domain.image.validation.ImageValidation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ShirtService {

    @Value("${spring.data.web.pageable.default-page-size}")
    private int MAX_PAGE_SIZE;

    private final ShirtMapper shirtMapper;

    private final ShirtRepository shirtRepository;
    private final ColorRepository colorRepository;
    private final BrandRepository brandRepository;
    private final ImageRepository imageRepository;

    public ShirtService(
            ShirtRepository shirtRepository,
            ColorRepository colorRepository,
            BrandRepository brandRepository,
            ImageRepository imageRepository,
            ShirtMapper shirtMapper
    ){
        this.shirtRepository = shirtRepository;
        this.colorRepository = colorRepository;
        this.brandRepository = brandRepository;
        this.imageRepository = imageRepository;
        this.shirtMapper = shirtMapper;
    }

    public Page<Shirt> getAllShirts(Pageable pageable) {
        return shirtRepository.findAll(pageable);
    }

    public Shirt saveShirt(CreateShirtRequest shirt) {

        Color color = colorRepository.findById(shirt.colorId())
                .orElseThrow(() -> new ColorException("Color not found"));

        Brand brand = brandRepository.findById(shirt.brandId())
                .orElseThrow(() -> new ColorException("Brand not found"));

        shirt.images().forEach(image -> {
            ImageValidation.verify(image);
            imageRepository.save(image);
        });

        Shirt newShirt = shirtMapper.ShirtRequestToShirt(shirt, color, brand);

        return shirtRepository.save(newShirt);
    }
}
