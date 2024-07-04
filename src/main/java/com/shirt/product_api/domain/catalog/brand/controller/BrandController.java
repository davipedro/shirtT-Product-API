package com.shirt.product_api.domain.catalog.brand.controller;

import com.shirt.product_api.domain.catalog.brand.dto.CreateBrandRequest;
import com.shirt.product_api.domain.catalog.brand.dto.UpdateBrandRequest;
import com.shirt.product_api.domain.catalog.brand.model.Brand;
import com.shirt.product_api.domain.catalog.brand.service.BrandService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
public class BrandController {

    BrandService brandService;

    BrandController(BrandService brandService){
        this.brandService = brandService;
    }

    @PostMapping("/brand")
    public ResponseEntity<Brand> createBrand(@RequestBody @Valid CreateBrandRequest createBrandRequest){
        Brand newBrand = brandService.createBrand(createBrandRequest);
        return ResponseEntity.ok().body(newBrand);
    }

    @GetMapping
    public ResponseEntity<List<Brand>> getAllBrands(){
        List<Brand> brands = brandService.getAllBrands();
        return ResponseEntity.ok().body(brands);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Brand> getBrandById(@PathVariable Long id){
        Brand brand = brandService.getBrandById(id);
        return ResponseEntity.ok().body(brand);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Brand> updateBrand(@PathVariable Long id, @Valid @RequestBody UpdateBrandRequest createBrandRequest){
        Brand updatedBrand = brandService.updateBrand(id, createBrandRequest);
        return ResponseEntity.ok().body(updatedBrand);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBrand(@PathVariable Long id){
        brandService.deleteBrand(id);
        return ResponseEntity.noContent().build();
    }
}
