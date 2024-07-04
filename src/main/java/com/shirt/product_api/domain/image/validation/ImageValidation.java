package com.shirt.product_api.domain.image.validation;

import com.shirt.product_api.domain.image.exception.ImageValidationException;
import com.shirt.product_api.domain.image.model.Image;
import com.shirt.product_api.domain.image.model.enums.ImageType;

public class ImageValidation {
    public static final String URL_REGEX = "https://www\\.[A-Za-z][A-Za-z]+\\.[A-Za-z]+/[a-zA-Z0-9-_@:%+.~#?&/=]*";

    public static void verify(Image image) {

        ImageType type = image.getType();
        String url = image.getUrl();

        if (!isValidType(type.toString())) throw new ImageValidationException("Invalid image type");

        if (!isValidUrl(url)) throw new ImageValidationException("Invalid image URL, use the format: https://www.example.com/path");
    }

    private static boolean isValidType(String type) {
        return ImageType.isValid(type);
    }

    private static boolean isValidUrl(String url) {
        if (url == null || url.isEmpty()) return false;

        return url.matches(URL_REGEX);
    }
}
