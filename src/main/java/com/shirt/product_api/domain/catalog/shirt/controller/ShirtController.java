package com.shirt.product_api.domain.catalog.shirt.controller;

import com.shirt.product_api.domain.catalog.shirt.dto.request.create.CreateShirtRequest;
import com.shirt.product_api.domain.catalog.shirt.model.Shirt;
import com.shirt.product_api.domain.catalog.shirt.service.ShirtService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
* TODO: add endpoint for:
*  - get shirt by id
* - get shirt by name
* - get shirt by size
* - get shirt by color
* - get shirt by price
* - get shirt by brand
* */

@RestController
@RequestMapping("api/shirts")
public class ShirtController {

    ShirtService shirtService;

    ShirtController(ShirtService shirtService){
        this.shirtService = shirtService;
    }

    @PostMapping("/shirt")
    private ResponseEntity<Shirt> saveShirt(@RequestBody CreateShirtRequest shirt){

        Shirt savedShirt = shirtService.saveShirt(shirt);

        return ResponseEntity.ok().body(savedShirt);
    }

    @GetMapping
    private ResponseEntity<List<Shirt>> getAllShirts(Pageable pageable){
        Page<Shirt> pagedShirts = shirtService
                .getAllShirts(pageable);
        return ResponseEntity.ok().body(pagedShirts.getContent());
    }
}
