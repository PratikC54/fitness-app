package com.PratikC54.fitness_app.service;

import com.PratikC54.fitness_app.dto.RecommendationRequest;
import com.PratikC54.fitness_app.model.Activity;
import com.PratikC54.fitness_app.model.Recommendation;
import com.PratikC54.fitness_app.model.User;
import com.PratikC54.fitness_app.repository.ActivityRepository;
import com.PratikC54.fitness_app.repository.RecommendationRepository;
import com.PratikC54.fitness_app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecommendationService {

    private final RecommendationRepository recommendationRepository;
    private final UserRepository userRepository;
    private final ActivityRepository activityRepository;

    public Recommendation generateRecommendation(RecommendationRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("No user found"+request.getUserId()));

        Activity activity = activityRepository.findById(request.getActivityId())
                .orElseThrow(() -> new RuntimeException("No activity found"+request.getActivityId()));
        Recommendation recommendation = Recommendation.builder()
                .user(user)
                .activity(activity)
                .improvements(request.getImprovements())
                .suggestions(request.getSuggestions())
                .safety(request.getSafety())
                .recommendation(request.getRecommendation())
                .type(request.getType())
                .build();

        return recommendationRepository.save(recommendation);
    }

    public List<Recommendation> getRecommendation(String userId) {
         return recommendationRepository.findByUserId(userId);
    }

    public List<Recommendation> getActivityRecommendation(String activityId) {
        return recommendationRepository.findByActivityId(activityId);
    }
}
