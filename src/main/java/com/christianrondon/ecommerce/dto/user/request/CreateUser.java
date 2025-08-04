package com.christianrondon.ecommerce.dto.user.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

/*
DTO Request class to receive the parameters for CREATE a user
 */
public class CreateUser {
    @NotBlank(message = "is required")
    private String name;
    @NotBlank(message = "is required")
    private String email;
}
