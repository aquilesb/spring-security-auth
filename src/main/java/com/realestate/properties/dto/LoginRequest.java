package com.realestate.properties.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
    @NotBlank(message = "Field username should be sent.")
    private String username;

    @NotBlank(message = "Field password should be sent.")
    private String password;
}
