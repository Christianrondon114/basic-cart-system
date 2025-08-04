package com.christianrondon.ecommerce.mapper;

import com.christianrondon.ecommerce.dto.product.request.CreateProduct;
import com.christianrondon.ecommerce.dto.product.request.UpdateProduct;
import com.christianrondon.ecommerce.dto.product.response.ProductResponse;
import com.christianrondon.ecommerce.entity.Product;

public class ProductMapper {

    public static ProductResponse toProductResponse(Product product){
        return new ProductResponse(product.getProductId(), product.getName(), product.getDescription(), product.getPrice(), product.getCategory(),product.getImageUrl());
    }

    public static Product toEntity(CreateProduct product){
        return new Product(product.getName(), product.getDescription(), product.getPrice(), product.getCategory(), product.getImageUrl());
    }
}
