package com.christianrondon.ecommerce.controller;


import com.christianrondon.ecommerce.dto.shoppingcart.response.ShoppingCartResponse;
import com.christianrondon.ecommerce.service.ShoppingCartService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shopping-carts")
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;

    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping("/user/{id}")
    public ShoppingCartResponse getShoppingCartByUserId(@PathVariable Long id) {
        return shoppingCartService.getShoppingCartByUserId(id);
    }

    @DeleteMapping("clear/user/{id}")
    public void clearCart(@PathVariable Long id) {
        shoppingCartService.clearCart(id);
    }

    @DeleteMapping("kill/user/{id}")
    public void deleteCartByUserId(Long id){
        shoppingCartService.deleteCartByUserId(id);
    }

    }
