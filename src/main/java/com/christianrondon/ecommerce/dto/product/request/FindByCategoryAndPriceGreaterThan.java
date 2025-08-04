package com.christianrondon.ecommerce.dto.product.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class FindByCategoryAndPriceGreaterThan {
    @NotBlank(message = "category is required")
    private String category;
    @NotNull(message = "price is required")
    private double priceGreaterThan;
}
