package com.christianrondon.ecommerce.dto.cartitem.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AddToCart {
    private Long userId;
    private Long productId;
    private int quantity;
}
