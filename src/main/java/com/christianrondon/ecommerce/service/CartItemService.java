package com.christianrondon.ecommerce.service;


import com.christianrondon.ecommerce.dto.cartitem.request.AddToCart;
import com.christianrondon.ecommerce.dto.cartitem.response.CartItemResponse;
import com.christianrondon.ecommerce.entity.CartItem;
import com.christianrondon.ecommerce.entity.Product;
import com.christianrondon.ecommerce.entity.ShoppingCart;
import com.christianrondon.ecommerce.entity.User;
import com.christianrondon.ecommerce.exception.ResourceNotFoundException;
import com.christianrondon.ecommerce.mapper.CartItemMapper;
import com.christianrondon.ecommerce.repository.CartItemRepository;
import com.christianrondon.ecommerce.repository.ProductRepository;
import com.christianrondon.ecommerce.repository.ShoppingCartRepository;
import com.christianrondon.ecommerce.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CartItemService {
    private final CartItemRepository cartItemRepository;
    private final ShoppingCartRepository shoppingCartRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public CartItemService(CartItemRepository cartItemRepository,
                           ShoppingCartRepository shoppingCartRepository,
                           UserRepository userRepository,
                           ProductRepository productRepository){
        this.cartItemRepository = cartItemRepository;
        this.shoppingCartRepository = shoppingCartRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    public CartItemResponse addToCart(AddToCart request){
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + request.getUserId()));

        ShoppingCart cart = shoppingCartRepository.findByUser_Id(request.getUserId())
                .orElseGet(() -> createCart(user));

        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with ID: " + request.getProductId()));

        CartItem item = CartItem.builder()
                .shoppingCart(cart)
                .product(product)
                .quantity(request.getQuantity())
                .subtotal(request.getQuantity() * product.getPrice())
                .build();

        CartItem savedItem = cartItemRepository.save(item);

        return CartItemMapper.toResponse(savedItem);
    }

    private ShoppingCart createCart(User user) {
        ShoppingCart newCart = new ShoppingCart();
        newCart.setUser(user);
        newCart.setListItems(new ArrayList<>());
        return shoppingCartRepository.save(newCart);
    }


}
