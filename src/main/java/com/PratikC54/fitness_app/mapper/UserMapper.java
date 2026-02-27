package com.PratikC54.fitness_app.mapper;

import com.PratikC54.fitness_app.dto.UserResponse;
import com.PratikC54.fitness_app.model.User;

public class UserMapper {

    public static UserResponse mapToResponse(User savedUser) {
        UserResponse response = new UserResponse();
        response.setId(savedUser.getId());
        response.setEmail(savedUser.getEmail());
        response.setFirstName(savedUser.getFirstName());
        response.setLastName(savedUser.getLastName());
        response.setPassword(savedUser.getPassword());
        response.setCreatedAt(savedUser.getCreatedAt());
        response.setUpdatedAt(savedUser.getUpdatedAt());
        return response;
    }
}
