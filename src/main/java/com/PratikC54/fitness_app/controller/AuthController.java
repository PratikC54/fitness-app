package com.PratikC54.fitness_app.controller;

import com.PratikC54.fitness_app.dto.RegisterRequest;
import com.PratikC54.fitness_app.dto.UserResponse;
import com.PratikC54.fitness_app.model.User;
import com.PratikC54.fitness_app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> Register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(userService.register(request));
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }
}