package com.shirt.product_api.domain.catalog.color.controller;

import com.shirt.product_api.domain.catalog.color.dto.CreateColorRequest;
import com.shirt.product_api.domain.catalog.color.dto.UpdateColorRequest;
import com.shirt.product_api.domain.catalog.color.service.ColorService;
import com.shirt.product_api.domain.catalog.color.model.Color;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/colors")
public class ColorController {

    private final ColorService colorService;

    ColorController(ColorService colorService) {
        this.colorService = colorService;
    }

    @PostMapping()
    private ResponseEntity<Color> createColor(@RequestBody @Valid CreateColorRequest color) {
        var newColor = colorService.saveColor(color);
        return ResponseEntity.ok(newColor);
    }

    @GetMapping()
    private ResponseEntity<List<Color>> getAllColors() {
       var colors = colorService.getAllColors();
       return ResponseEntity.ok(colors);
    }

    @GetMapping("/{id}")
    private ResponseEntity<Color> getColorById(@PathVariable Long id) {
        var colors = colorService.getColorById(id);
        return ResponseEntity.ok(colors);
    }

    @PutMapping("/{id}")
    private ResponseEntity<Color> updateColor(@PathVariable Long id, @Valid @RequestBody UpdateColorRequest color) {
        var updatedColor = colorService.updateColor(id, color);
        return ResponseEntity.ok(updatedColor);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> deleteColor(@PathVariable Long id) {
        colorService.deleteColor(id);
        return ResponseEntity.noContent().build();
    }
}
