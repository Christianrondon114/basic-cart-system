package com.christianrondon.ecommerce.dto.shoppingcart.response;

import com.christianrondon.ecommerce.dto.cartitem.response.CartItemResponse;
import com.christianrondon.ecommerce.entity.CartItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ShoppingCartResponse {
    private Long ShoppingCartId;
    private Long userId;
    private List<CartItemResponse> listItems;
    private double totalPrice;
}
