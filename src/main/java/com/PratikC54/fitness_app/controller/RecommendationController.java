package com.PratikC54.fitness_app.controller;

import com.PratikC54.fitness_app.dto.RecommendationRequest;
import com.PratikC54.fitness_app.model.Recommendation;
import com.PratikC54.fitness_app.service.RecommendationService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recommendation")
@RequiredArgsConstructor
public class RecommendationController {
    private final RecommendationService recommendationService;

    @PostMapping("/generate")
    public ResponseEntity<Recommendation> generateRecpmmendation(@RequestBody RecommendationRequest request) {
        Recommendation recommendation =recommendationService.generateRecommendation(request);
        return ResponseEntity.ok(recommendation);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Recommendation>> getUserRecommendation(@PathVariable String userId) {
        return ResponseEntity.ok(recommendationService.getRecommendation(userId));
    }


    @GetMapping("/activity/{activityId}")
    public ResponseEntity<List<Recommendation>> getactivityRecommendation(@PathVariable String activityId) {
        return ResponseEntity.ok(recommendationService.getActivityRecommendation(activityId));
    }

}
