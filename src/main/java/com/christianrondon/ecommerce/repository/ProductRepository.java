package com.christianrondon.ecommerce.repository;

import com.christianrondon.ecommerce.entity.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long>{

    List<Product> findByCategory(String category);
    List<Product> findByPrice(Double price);
    List<Product> findByName(String name);
    List<Product> findByNameAndCategory(String name, String category);
    List<Product> findByCategoryAndPriceLessThan(String category, double priceLessThan);
    List<Product> findByCategoryAndPriceGreaterThan(String category, double priceGreaterThan);

    @Transactional
    @Modifying
    @Query("UPDATE Product p SET p.category = :newCategory WHERE p.productId = :productId")
    int patchProductCategory(@Param("productId") Long productId, @Param("newCategory") String newCategory);

    @Transactional
    @Modifying
    @Query("UPDATE Product p SET p.name = :newName WHERE p.productId = :productId")
    int patchProductName(@Param("productId")Long productId, @Param("newName") String mewName);

    @Transactional
    @Modifying
    @Query("UPDATE Product p SET p.description = :newDesc WHERE p.productId = :productId")
    int patchProductDescription(@Param("productId") Long productId, @Param("newDesc")String newDesc);
}
