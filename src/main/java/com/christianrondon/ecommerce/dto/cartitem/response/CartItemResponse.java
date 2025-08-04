package com.christianrondon.ecommerce.dto.cartitem.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CartItemResponse {
    private Long itemId;
    private Long productId;
    private String productName;
    private double productPrice;
    private int quantity;
    private BigDecimal subtotal;

}
