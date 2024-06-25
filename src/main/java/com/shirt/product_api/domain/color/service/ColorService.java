package com.shirt.product_api.domain.color.service;

import com.shirt.product_api.domain.color.dto.CreateColorRequest;
import com.shirt.product_api.domain.color.dto.UpdateColorRequest;
import com.shirt.product_api.domain.color.exception.ColorException;
import com.shirt.product_api.domain.color.model.Color;
import com.shirt.product_api.domain.color.repository.ColorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

// TODO: - Criar testes unitários e de integração necessários
@Service
public class ColorService {

    ColorRepository colorRepository;

    ColorService(ColorRepository colorRepository) {
        this.colorRepository = colorRepository;
    }

    public List<Color> getAllColors() {
        return colorRepository.findAll();
    }

    public Color getColorById(Long id) {
        return colorRepository.findById(id)
                .orElseThrow(() -> new ColorException("Color not found"));
    }

    public Color saveColor(CreateColorRequest color) {

        if (color.hex() == null || color.name() == null)
            throw new ColorException("Name and hex are required");

        isValidHex((color.hex()));

        Color newColor = new Color();
        newColor.setName(color.name());
        newColor.setHex(color.hex());

        return colorRepository.save(newColor);
    }

    private boolean isValidHex(String hex) {
        if (!hex.matches("^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$")) {
            throw new ColorException("Invalid hex, use: #RRGGBB or #RGB");
        }
        return true;
    }

    public Color updateColor(Long id, UpdateColorRequest updatedColor) {

        Color color = colorRepository.findById(id)
                .orElseThrow(() -> new ColorException("Color not found"));

        if (updatedColor.name() != null) color.setName(updatedColor.name());

        //TODO: possibilidade de refatorar para extrair as validações caso aumente o número de validações
        if (updatedColor.hex() != null && isValidHex((updatedColor.hex()))){
            color.setHex(updatedColor.hex());
        }

        //TODO: Validar o hex e o name da cor salvam no banco
        return colorRepository.save(color);
    }

    public void deleteColor(Long id) {
        colorRepository.findById(id)
                .orElseThrow(() -> new ColorException("Color not found"));

        colorRepository.deleteById(id);
    }
}
