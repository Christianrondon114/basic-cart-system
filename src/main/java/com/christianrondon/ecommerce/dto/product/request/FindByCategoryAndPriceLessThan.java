package com.christianrondon.ecommerce.dto.product.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FindByCategoryAndPriceLessThan {
    @NotBlank(message = "category is required")
    private String category;
    @Min(value = 1, message = "price must be greater than 0")
    private double priceLessThan;
}
