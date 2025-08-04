package com.christianrondon.ecommerce.controller;

import com.christianrondon.ecommerce.dto.user.request.*;
import com.christianrondon.ecommerce.dto.user.response.UserResponse;
import com.christianrondon.ecommerce.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    // ----------------- CRUD USER ----------------

    @GetMapping
    public List<UserResponse> showAllUsers() {
        return userService.showAllUsers();
    }

    @PostMapping
    public UserResponse createUser(@RequestBody @Valid CreateUser request) {
        return userService.createUser(request);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Long id) {
        userService.deleteUserById(id);
    }

    @PutMapping("/{id}")
    public UserResponse updateUser(@PathVariable Long id, @RequestBody @Valid UpdateUser request) {
        return userService.updateUser(id, request);
    }


    // ------------------ FILTER --------------------------

    @PostMapping("/search/name")
    public List<UserResponse> findByName(@RequestBody @Valid FindUserByName request) {
        return userService.findByName(request);
    }

    @PostMapping("/search/email")
    public List<UserResponse> findByEmail(@RequestBody @Valid FindUserByEmail request) {
        return userService.findByEmail(request);
    }

    @PatchMapping("/patch/name/{id}")
    public UserResponse PatchUserName(@PathVariable Long id, @RequestBody @Valid PatchUserName request) {
        return userService.patchUserName(id, request);
    }

    @PatchMapping("/patch/email/{id}")
    public UserResponse patchUserEmail(@PathVariable Long id, @RequestBody @Valid PatchUserEmail request) {
        return userService.patchUserEmail(id, request);
    }

}

