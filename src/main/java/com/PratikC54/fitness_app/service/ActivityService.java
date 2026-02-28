package com.PratikC54.fitness_app.service;

import com.PratikC54.fitness_app.dto.ActivityRequest;
import com.PratikC54.fitness_app.dto.ActivityResponse;
import com.PratikC54.fitness_app.mapper.ActivityMapper;
import com.PratikC54.fitness_app.model.Activity;
import com.PratikC54.fitness_app.model.User;
import com.PratikC54.fitness_app.repository.ActivityRepository;
import com.PratikC54.fitness_app.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActivityService {
    
    private final ActivityRepository activityRepository;
    private final UserRepository userRepository;

    public ActivityResponse trackActivity(ActivityRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("Invalid user : "+request.getUserId()));
        Activity activity = Activity.builder()
                .user(user)
                .type(request.getType())
                .duration(request.getDuration())
                .caloriesBurned(request.getCaloriesBurned())
                .startTime(request.getStartTime())
                .additionalMetrices(request.getAdditionalMetrices())
                .build();
        Activity savedActivity = activityRepository.save(activity);
        return ActivityMapper.mapToResponse(savedActivity);
    }


    public List<ActivityResponse> getAllUserActivity() {
        List<Activity> activityList = activityRepository.findAll();
        return ActivityMapper.mapToResponseList(activityList);
    }

    public List<ActivityResponse> getUserActivity(String userId) {
        List<Activity> activityList = activityRepository.findByUserId(userId);
        return ActivityMapper.mapToResponseList(activityList);
    }
}
