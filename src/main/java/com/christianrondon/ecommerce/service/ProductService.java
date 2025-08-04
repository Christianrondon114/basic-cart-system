package com.christianrondon.ecommerce.service;

import com.christianrondon.ecommerce.dto.product.request.*;
import com.christianrondon.ecommerce.dto.product.response.ProductResponse;
import com.christianrondon.ecommerce.entity.Product;
import com.christianrondon.ecommerce.exception.ResourceNotFoundException;
import com.christianrondon.ecommerce.mapper.ProductMapper;
import com.christianrondon.ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    // -------------------CRUD METHODS------------------

    // READ
    public List<ProductResponse> showAllProducts(){
        List<Product> products = productRepository.findAll();
        return mapToResponse(products);
    }

    // CREATE
    public ProductResponse createProduct(CreateProduct request){
        Product product = ProductMapper.toEntity(request);
        Product savedProduct = productRepository.save(product);
        return ProductMapper.toProductResponse(savedProduct);
    }

    // DELETE
    public void deleteProductById(Long Id){
        productRepository.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("Product with ID " + Id + " not found."));

        productRepository.deleteById(Id);
    }

    // UPDATE
    public ProductResponse updateProduct(Long id, UpdateProduct request){
        Product productFound = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product with ID " + id + " not found."));

        productFound.setName(request.getName());
        productFound.setDescription(request.getDescription());
        productFound.setPrice(request.getPrice());
        productFound.setCategory(request.getCategory());
        productFound.setImageUrl(request.getImageUrl());

        Product updated = productRepository.save(productFound);
        return ProductMapper.toProductResponse(updated);
    }

    //-------------------- FILTER--------------------------------

    public List<ProductResponse> findByCategory(FindByCategory request){
        List<Product> products = productRepository.findByCategory(request.getCategory());
        return mapToResponse(products);
    }

    public List<ProductResponse> findByPrice(FindByPrice request){
        List<Product> products = productRepository.findByPrice(request.getPrice());
        return mapToResponse(products);
    }

    public List<ProductResponse> findByName(FindByName request){
        List<Product> products = productRepository.findByName(request.getName());
        return mapToResponse(products);
    }

    public List<ProductResponse> findByNameAndCategory(FindByNameAndCategory request){
        List<Product> products = productRepository.findByNameAndCategory(request.getName(), request.getCategory());
        return mapToResponse(products);
    }

    public List<ProductResponse> findByCategoryAndPriceLessThan(FindByCategoryAndPriceLessThan request){
        List<Product> products = productRepository.findByCategoryAndPriceLessThan(request.getCategory(), request.getPriceLessThan());
        return mapToResponse(products);
    }

    public List<ProductResponse>findByCategoryAndPriceGreaterThan(FindByCategoryAndPriceGreaterThan request){
        List<Product> products = productRepository.findByCategoryAndPriceGreaterThan(request.getCategory(), request.getPriceGreaterThan());
        return mapToResponse(products);
    }

    // PATCH CATEGORY - DESCRIPTION - NAME
    public ProductResponse PatchProductCategory(Long id, PatchProductCategory request){
        int updated = productRepository.patchProductCategory(id, request.getCategory());
        return validateAndReturnUpdatedProduct(updated, id);
    }

    public ProductResponse PatchProductDescription(Long id, PatchProductDescription request){
         int updated = productRepository.patchProductDescription(id, request.getDescription());
         return validateAndReturnUpdatedProduct(updated, id);
    }

    public ProductResponse PatchProductName(Long id, PatchProductName request){
         int updated = productRepository.patchProductName(id, request.getName());
         return validateAndReturnUpdatedProduct(updated, id);
    }

    private ProductResponse validateAndReturnUpdatedProduct(int updated, Long id) {
        if (updated == 0) {
            throw new ResourceNotFoundException("Product ID " + id + " not found");
        }

        Product updatedProduct = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product ID " + id + " not found"));

        return ProductMapper.toProductResponse(updatedProduct);
    }

    private List<ProductResponse> mapToResponse(List<Product> products){
        return products.stream()
                .map(ProductMapper::toProductResponse)
                .toList();
    }
}
