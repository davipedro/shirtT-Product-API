package com.shirt.product_api.domain.color.controller;

import com.shirt.product_api.domain.color.dto.CreateColorRequest;
import com.shirt.product_api.domain.color.dto.UpdateColorRequest;
import com.shirt.product_api.domain.color.model.Color;
import com.shirt.product_api.domain.color.service.ColorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/color")
public class ColorController {

    private final ColorService colorService;

    ColorController(ColorService colorService) {
        this.colorService = colorService;
    }

    @PostMapping()
    private ResponseEntity<Color> createColor(@RequestBody CreateColorRequest color) {
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
    private ResponseEntity<Color> updateColor(@PathVariable Long id, @RequestBody UpdateColorRequest color) {
        var updatedColor = colorService.updateColor(id, color);
        return ResponseEntity.ok(updatedColor);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> deleteColor(@PathVariable Long id) {
        colorService.deleteColor(id);
        return ResponseEntity.noContent().build();
    }
}
