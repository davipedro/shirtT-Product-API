package com.shirt.product_api.domain.catalog.color.validation;

import com.shirt.product_api.domain.catalog.color.exception.ColorException;
import com.shirt.product_api.domain.catalog.color.model.Color;

public class ColorValidation {

    public static void validateNewColor(Color color){

        String mainColor = color.getMainColor();
        String hex = color.getHex();
        String fullName = color.getFullName();

        validateHex(hex);
        validateMainColor(mainColor);
    }

    public static void validateHex(String hex){
        if (!hex.matches("^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$")) {
            throw new ColorException("Invalid hex, use: #RRGGBB or #RGB");
        }
    }

    private static void validateMainColor(String mainColor){
        if(mainColor == null || mainColor.isBlank()){
            throw new ColorException("Main color is required");
        }
        //cor só pode ter letras
        if(!mainColor.matches("^[a-zA-Z]*$")){
            throw new ColorException("Main color must have only letters");
        }
    }
}
