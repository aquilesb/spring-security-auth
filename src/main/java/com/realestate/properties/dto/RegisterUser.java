package com.realestate.properties.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUser implements Serializable {

    private Long id;

    @NotBlank(message = "Field name should be sent.")
    private String name;

    @NotBlank(message = "Field email should be sent.")
    private String email;

    @NotBlank(message = "Field username should be sent.")
    private String username;

    @NotBlank(message = "Field password should be sent.")
    private String password;

    @NotEmpty(message = "Field roles should be sent.")
    private List<Long> roles;
}
