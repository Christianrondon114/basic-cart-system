package com.christianrondon.ecommerce.mapper;

import com.christianrondon.ecommerce.dto.cartitem.response.CartItemResponse;
import com.christianrondon.ecommerce.entity.CartItem;
import com.christianrondon.ecommerce.entity.Product;

public class CartItemMapper {
    public static CartItemResponse toResponse(CartItem cartItem){
        return new CartItemResponse(
                cartItem.getId(),
                cartItem.getProduct().getProductId(),
                cartItem.getProduct().getName(),
                cartItem.getProduct().getPrice(),
                cartItem.getQuantity(),
                cartItem.getSubtotal());

    }

}
