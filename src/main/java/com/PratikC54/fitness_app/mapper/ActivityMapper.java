package com.PratikC54.fitness_app.mapper;

import com.PratikC54.fitness_app.dto.ActivityResponse;
import com.PratikC54.fitness_app.model.Activity;

import java.util.List;

public class ActivityMapper {
    public static ActivityResponse mapToResponse(Activity savedActivity) {
        ActivityResponse response = new ActivityResponse();
        response.setId(savedActivity.getId());
        response.setUserId(savedActivity.getUser().getId());
        response.setType(savedActivity.getType());
        response.setDuration(savedActivity.getDuration());
        response.setCaloriesBurned(savedActivity.getCaloriesBurned());
        response.setStartTime(savedActivity.getStartTime());
        response.setAdditionalMetrices(savedActivity.getAdditionalMetrices());
        response.setUpdatedAt(savedActivity.getUpdatedAt());
        return response;
    }

    public static List<ActivityResponse> mapToResponseList(List<Activity> activities) {
        return activities.stream()
                .map(ActivityMapper::mapToResponse)
                .toList();
    }
}
