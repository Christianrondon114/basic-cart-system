package com.christianrondon.ecommerce.dto.product.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateProduct {
    @NotBlank(message = "required")
    @Size(max = 100, message = "the name can't be more than 100 characters")
    private String name;
    @Size(max = 300, message = "the description can't be more than 300 characters")
    private String description;
    @Min(value = 1, message = "price must be greater than 0")
    private double price;
    @NotBlank(message = "category is required")
    private String category;
    @Size(max = 500, message = "image URL can't exceed 500 characters")
    private String imageUrl;
}
