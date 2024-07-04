package com.shirt.product_api.domain.catalog.color.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record UpdateColorRequest(String fullName, String mainColor,String hex){
}
