package com.christianrondon.ecommerce.controller;

import com.christianrondon.ecommerce.dto.product.request.*;
import com.christianrondon.ecommerce.dto.product.response.ProductResponse;
import com.christianrondon.ecommerce.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

// ---------- CRUD OPERATIONS ----------

    @GetMapping
    public List<ProductResponse> showAllProducts() {
        return productService.showAllProducts();
    }
// ---------- CRUD OPERATIONS ----------

    @PostMapping
    public ProductResponse createProduct(@RequestBody @Valid CreateProduct request) {
        return productService.createProduct(request);
    }
// ---------- CRUD OPERATIONS ----------

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable Long id) {
        productService.deleteProductById(id);
    }
// ---------- CRUD OPERATIONS ----------

    @PutMapping("/{id}")
    public ProductResponse updateProduct(@PathVariable Long id, @RequestBody @Valid UpdateProduct request) {
        return productService.updateProduct(id, request);
    }
// ---------- SEARCH / FILTER METHODS ----------

    @PostMapping("/search/category")
    public List<ProductResponse> findByCategory(@RequestBody @Valid FindByCategory request) {
        return productService.findByCategory(request);
    }
// ---------- SEARCH / FILTER METHODS ----------

    @PostMapping("/search/price")
    public List<ProductResponse> findByPrice(@RequestBody @Valid FindByPrice request) {
        return productService.findByPrice(request);
    }
// ---------- SEARCH / FILTER METHODS ----------

    @PostMapping("/search/name")
    public List<ProductResponse> findByName(@RequestBody @Valid FindByName request) {
        return productService.findByName(request);
    }
// ---------- SEARCH / FILTER METHODS ----------

    @PostMapping("/search/name-category")
    public List<ProductResponse> findByNameAndCategory(@RequestBody @Valid FindByNameAndCategory request) {
        return productService.findByNameAndCategory(request);
    }
// ---------- SEARCH / FILTER METHODS ----------

    @PostMapping("/search/category-priceless")
    public List<ProductResponse> findByCategoryAndPriceLessThan(@RequestBody @Valid FindByCategoryAndPriceLessThan request) {
        return productService.findByCategoryAndPriceLessThan(request);
    }
// ---------- SEARCH / FILTER METHODS ----------

    @PostMapping("/search/category-price_greater")
    public List<ProductResponse> findByCategoryAndPriceGreaterThan(@RequestBody @Valid FindByCategoryAndPriceGreaterThan request) {
        return productService.findByCategoryAndPriceGreaterThan(request);
    }

    @PatchMapping("/patch/category/{id}")
    public ProductResponse PatchProductCategory(@PathVariable Long id, @RequestBody @Valid PatchProductCategory request) {
        return productService.PatchProductCategory(id, request);
    }

    @PatchMapping("/patch/description/{id}")
    public ProductResponse PatchProductDescription(@PathVariable Long id, @RequestBody @Valid PatchProductDescription request) {
        return productService.PatchProductDescription(id, request);
    }

    @PatchMapping("/patch/name/{id}")
    public ProductResponse PatchProductName(@PathVariable Long id, @RequestBody @Valid PatchProductName request) {
        return productService.PatchProductName(id, request);
    }

}
