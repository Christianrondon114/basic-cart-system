package com.christianrondon.ecommerce.dto.product.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductResponse {
    private Long id;
    private String name;
    private String description;
    private double price;
    private String category;
    private String imageUrl;
}
