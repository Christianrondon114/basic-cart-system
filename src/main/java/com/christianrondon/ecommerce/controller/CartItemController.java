package com.christianrondon.ecommerce.controller;

import com.christianrondon.ecommerce.dto.cartitem.request.AddToCart;
import com.christianrondon.ecommerce.dto.cartitem.response.CartItemResponse;
import com.christianrondon.ecommerce.repository.CartItemRepository;
import com.christianrondon.ecommerce.service.CartItemService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart-items")
public class CartItemController {

    public final CartItemService cartItemService;

    public CartItemController(CartItemService cartItemService) {
        this.cartItemService = cartItemService;
    }

    @PostMapping("/add")
    public CartItemResponse addToCart(@RequestBody AddToCart request) {
        return cartItemService.addToCart(request);
    }
}