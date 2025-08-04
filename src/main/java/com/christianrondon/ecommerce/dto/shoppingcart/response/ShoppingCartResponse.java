package com.christianrondon.ecommerce.dto.shoppingcart.response;

import com.christianrondon.ecommerce.dto.cartitem.response.CartItemResponse;
import java.math.BigDecimal;
import java.util.List;

public class ShoppingCartResponse {
    private Long shoppingId;
    private Long userId;
    private List<CartItemResponse> listItems;
    private int totalItems;
    private BigDecimal totalPrice;
}
