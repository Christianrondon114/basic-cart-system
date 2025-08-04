package com.christianrondon.ecommerce.dto.product.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class FindByCategory {
    @NotBlank(message = "is required")
    private String category;
}
