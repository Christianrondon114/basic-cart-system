package com.christianrondon.ecommerce.service;

import com.christianrondon.ecommerce.dto.shoppingcart.response.ShoppingCartResponse;
import com.christianrondon.ecommerce.entity.CartItem;
import com.christianrondon.ecommerce.entity.ShoppingCart;
import com.christianrondon.ecommerce.entity.User;
import com.christianrondon.ecommerce.exception.ResourceNotFoundException;
import com.christianrondon.ecommerce.mapper.ShoppingCartMapper;
import com.christianrondon.ecommerce.repository.ShoppingCartRepository;
import com.christianrondon.ecommerce.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;
    private final UserRepository userRepository;

    public ShoppingCartService(ShoppingCartRepository shoppingCartRepository, UserRepository userRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.userRepository = userRepository;
    }

    // Get Users Shopping Cart through their ID.
    public ShoppingCartResponse getShoppingCartByUserId(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + id));

        ShoppingCart cart = shoppingCartRepository.findByUser_Id(id)
                .orElseGet(() -> createCart(user));

        updateTotalPrice(cart);

        return ShoppingCartMapper.toResponse(cart);
    }

    // Clear all Carts item by User ID
    public void clearCart(Long id) {
        ShoppingCart cart = shoppingCartRepository.findByUser_Id(id)
                .orElseThrow(() -> new ResourceNotFoundException("Shopping Cart not found"));

        cart.getListItems().forEach(i -> i.setShoppingCart(null));
        cart.getListItems().clear();

        shoppingCartRepository.save(cart);
    }

    public void updateTotalPrice(ShoppingCart cart) {
        double total = cart.getListItems()
                .stream()
                .mapToDouble(CartItem::getSubtotal)
                .sum();

        cart.setTotalPrice(total);
    }


    // Delete ShoppingCart from DB
    public void deleteCartByUserId(Long id) {
        ShoppingCart cart = shoppingCartRepository.findByUser_Id(id)
                .orElseThrow(() -> new ResourceNotFoundException("Shopping Cart not found"));

        cart.getListItems().forEach(i -> i.setShoppingCart(null));
        cart.getListItems().clear();
        shoppingCartRepository.save(cart);
        shoppingCartRepository.delete(cart);
    }


    private ShoppingCart createCart(User user) {
        ShoppingCart newCart = new ShoppingCart();
        newCart.setUser(user);
        newCart.setListItems(new ArrayList<>());
        return shoppingCartRepository.save(newCart);
    }
}

