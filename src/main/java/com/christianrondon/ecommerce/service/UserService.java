package com.christianrondon.ecommerce.service;


import com.christianrondon.ecommerce.dto.user.request.*;
import com.christianrondon.ecommerce.dto.user.response.UserResponse;
import com.christianrondon.ecommerce.entity.User;
import com.christianrondon.ecommerce.exception.ResourceNotFoundException;
import com.christianrondon.ecommerce.mapper.UserMapper;
import com.christianrondon.ecommerce.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    // returns all users from the database as a list of UserResponse DTOs to READ
    public List<UserResponse> showAllUsers() {
        List<User> userList = userRepository.findAll();
        return mapToResponse(userList);
    }

    // returns the CREATED user as object UserResponse DTOs
    public UserResponse createUser(CreateUser request) {
        User user = UserMapper.toEntity(request);
        User savedUser = userRepository.save(user);
        return UserMapper.toUserResponse(savedUser);
    }

    // DELETE a user through their id
    public void deleteUserById(Long id) {
        userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with ID " + id + " not found."));

        userRepository.deleteById(id);
    }

    // UPDATE a user through their id and the new parameters received
    public UserResponse updateUser(Long id, UpdateUser request) {
        User userFound = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with ID " + id + " not found."));

        userFound.setName(request.getName());
        userFound.setEmail(request.getEmail());

        User updatedUser = userRepository.save(userFound);
        return UserMapper.toUserResponse(updatedUser);
    }

    // A filter to search a specifics Users in a list through her name.
    public List<UserResponse> findByName(FindUserByName request) {
        List<User> userList = userRepository.findByName(request.getName());
        return mapToResponse(userList);
    }

    // A filter to search a specifics Users in a list through her email.
    public List<UserResponse> findByEmail(FindUserByEmail request) {
        List<User> userList = userRepository.findByEmail(request.getEmail());
        return mapToResponse(userList);
    }

    // A patch method where can update the name of a specific user through their ID.
    public UserResponse patchUserName(Long id, PatchUserName request) {
        int updatedUser = userRepository.patchUserName(id, request.getName());
        return validateAndReturnUpdatedUser(updatedUser, id);
    }

    // A patch method where can update the email of a specific user through their ID.
    public UserResponse patchUserEmail(Long id, PatchUserEmail request) {
        int updatedUser = userRepository.patchUserEmail(id, request.getEmail());
        return validateAndReturnUpdatedUser(updatedUser, id);
    }

    // A Method to help handle personalized query's
    private UserResponse validateAndReturnUpdatedUser(int updated, Long id) {
        if (updated == 0) {
            throw new ResourceNotFoundException("User ID " + id + " not found");
        }
        User updatedUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User ID " + id + " not found"));

        return UserMapper.toUserResponse(updatedUser);
    }

    // Maps a list of User entities to a list of UserResponse DTOs
    private List<UserResponse> mapToResponse(List<User> userList) {
        return userList.stream()
                .map(UserMapper::toUserResponse)
                .toList();
    }
}
