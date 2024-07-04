package com.shirt.product_api.domain.image.model.enums;

public enum ImageType {
    PNG,
    JPG,
    WEBP;

    public static boolean isValid(String value) {
        for (ImageType type : ImageType.values()) {
            if (type.name().equalsIgnoreCase(value)) {
                return true;
            }
        }
        return false;
    }
}
