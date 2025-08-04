package com.christianrondon.ecommerce.mapper;

import com.christianrondon.ecommerce.dto.product.request.CreateProduct;
import com.christianrondon.ecommerce.dto.user.request.CreateUser;
import com.christianrondon.ecommerce.dto.user.response.UserResponse;
import com.christianrondon.ecommerce.entity.Product;
import com.christianrondon.ecommerce.entity.User;

public class UserMapper {

    public static UserResponse toUserResponse(User user){
        return new UserResponse(user.getId(), user.getName(), user.getEmail());
    }

    // ---CREATE---
    public static User toEntity(CreateUser user){
        return new User(user.getName(), user.getEmail());
    }
}
