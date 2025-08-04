package com.christianrondon.ecommerce.repository;

import com.christianrondon.ecommerce.entity.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
}
