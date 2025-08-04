package com.christianrondon.ecommerce.dto.shoppingcart.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateShoppingCart {
    private Long userId;
}
