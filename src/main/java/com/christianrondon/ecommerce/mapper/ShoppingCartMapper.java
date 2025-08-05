package com.christianrondon.ecommerce.mapper;

import com.christianrondon.ecommerce.dto.cartitem.response.CartItemResponse;
import com.christianrondon.ecommerce.dto.shoppingcart.response.ShoppingCartResponse;
import com.christianrondon.ecommerce.entity.ShoppingCart;

import java.util.List;

public class ShoppingCartMapper {
    public static ShoppingCartResponse toResponse(ShoppingCart shoppingCart) {

        List<CartItemResponse> itemResponses = shoppingCart.getListItems()
                .stream()
                .map(CartItemMapper::toResponse)
                .toList();

        return new ShoppingCartResponse(
                shoppingCart.getShoppingCartId(),
                shoppingCart.getUser().getId(),
                itemResponses,
                shoppingCart.getTotalPrice()
        );
    }
}
