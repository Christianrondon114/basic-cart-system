package com.christianrondon.ecommerce.dto.product.request;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PatchProductCategory {
    @NotBlank(message = "is required")
    private String category;
}
