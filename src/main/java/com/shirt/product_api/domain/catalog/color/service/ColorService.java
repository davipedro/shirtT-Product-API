package com.shirt.product_api.domain.catalog.color.service;

import com.shirt.product_api.domain.catalog.color.repository.ColorRepository;
import com.shirt.product_api.domain.catalog.color.dto.CreateColorRequest;
import com.shirt.product_api.domain.catalog.color.dto.UpdateColorRequest;
import com.shirt.product_api.domain.catalog.color.exception.ColorException;
import com.shirt.product_api.domain.catalog.color.model.Color;
import com.shirt.product_api.domain.catalog.shirt.repository.ShirtRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

// TODO: - Criar testes unitários e de integração necessários
@Service
public class ColorService {

    ColorRepository colorRepository;

    ShirtRepository shirtRepository;

    ColorService(ColorRepository colorRepository, ShirtRepository shirtRepository) {
        this.colorRepository = colorRepository;
        this.shirtRepository = shirtRepository;
    }

    public List<Color> getAllColors() {
        return colorRepository.findAll();
    }

    public Color getColorById(Long id) {
        return colorRepository.findById(id)
                .orElseThrow(() -> new ColorException("Color not found"));
    }

    public Color saveColor(CreateColorRequest color) {

        isValidHex((color.hex()));

        //garantir que o full name seja salvo em lowercase
        String fullName = color.fullName().toLowerCase();

        Color newColor = new Color(color.mainColor(), color.hex(), color.fullName());

        colorRepository.findByFullName(color.fullName())
                .ifPresent(c -> {
                    throw new ColorException("Color already exists");
                });

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

        if (updatedColor.fullName() != null) color.setFullName(updatedColor.fullName());

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

        try {
            colorRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new ColorException("Color has something associated with it, can't be deleted");
        }
    }
}
