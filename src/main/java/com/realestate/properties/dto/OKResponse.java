package com.realestate.properties.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class OKResponse implements Serializable {

    private String message;
}
