package com.shirt.product_api.domain.catalog.brand.service;

import com.shirt.product_api.domain.catalog.brand.dto.CreateBrandRequest;
import com.shirt.product_api.domain.catalog.brand.dto.UpdateBrandRequest;
import com.shirt.product_api.domain.catalog.brand.exception.BrandException;
import com.shirt.product_api.domain.catalog.brand.model.Brand;
import com.shirt.product_api.domain.catalog.brand.repository.BrandRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BrandService {

    BrandRepository brandRepository;

    BrandService(BrandRepository brandRepository){
        this.brandRepository = brandRepository;
    }

    @Transactional
    public Brand createBrand(CreateBrandRequest createBrandRequest) {

        boolean brandExist = brandRepository
                .findByName(createBrandRequest.name()).isPresent();

        if (brandExist) throw new BrandException("Brand already exists");

        Brand newBrand = new Brand(createBrandRequest.name());

        return brandRepository.save(newBrand);
    }

    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

    public Brand getBrandById(Long id) {
        return brandRepository.findById(id)
                .orElseThrow(() -> new BrandException("Brand not found"));
    }

    public Brand updateBrand(Long id, UpdateBrandRequest createBrandRequest) {
        Brand brand = brandRepository.findById(id)
                .orElseThrow(() -> new BrandException("Brand not found"));

        if (createBrandRequest.name() != null)  brand.setName(createBrandRequest.name());

        return brandRepository.save(brand);
    }

    public void deleteBrand(Long id) {
        brandRepository.findById(id)
                .orElseThrow(() -> new BrandException("Brand not found"));

        try {
            brandRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new BrandException("Brand has something associated with it, can't be deleted");
        }
    }
}
