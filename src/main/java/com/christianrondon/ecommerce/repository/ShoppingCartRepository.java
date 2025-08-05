package com.christianrondon.ecommerce.repository;

import com.christianrondon.ecommerce.entity.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
    Optional<ShoppingCart> findByUser_Id(Long id);
}
