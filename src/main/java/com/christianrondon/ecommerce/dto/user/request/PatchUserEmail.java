package com.christianrondon.ecommerce.dto.user.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PatchUserEmail {
    @NotBlank(message = "is required")
    private String email;
}
