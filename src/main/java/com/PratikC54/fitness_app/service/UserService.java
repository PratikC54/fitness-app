package com.PratikC54.fitness_app.service;

import com.PratikC54.fitness_app.dto.RegisterRequest;
import com.PratikC54.fitness_app.dto.UserResponse;
import com.PratikC54.fitness_app.mapper.UserMapper;
import com.PratikC54.fitness_app.model.User;
import com.PratikC54.fitness_app.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponse register(RegisterRequest request) {

        User user = User.builder()
                .email(request.getEmail())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .password(request.getPassword())
                .build();
        User savedUser = userRepository.save(user);
        return UserMapper.mapToResponse(savedUser);
    }



    public List<User> getUsers() {
        return userRepository.findAll();
    }
}