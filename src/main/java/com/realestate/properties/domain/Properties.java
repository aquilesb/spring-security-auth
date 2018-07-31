package com.realestate.properties.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Properties {

    private Integer id;
    private String name;
    private String address;
    private String googleMaps;
    private String encodedURL;
    private BigDecimal price;
    private String status;
    private String description;
    private Integer bedrooms;
    private Integer bathrooms;
    private Integer parking;
    private Integer kitchen;

}


