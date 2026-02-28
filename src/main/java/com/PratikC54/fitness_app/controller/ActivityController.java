package com.PratikC54.fitness_app.controller;

import com.PratikC54.fitness_app.dto.ActivityRequest;
import com.PratikC54.fitness_app.dto.ActivityResponse;
import com.PratikC54.fitness_app.service.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activities")
@RequiredArgsConstructor
public class ActivityController {
    private final ActivityService activityService;

    @PostMapping
    public ResponseEntity<ActivityResponse> trackActivity(@RequestBody ActivityRequest request) {
        return ResponseEntity.ok(activityService.trackActivity(request));
    }

    @GetMapping
    public ResponseEntity<List<ActivityResponse>> getAllUserActivity() {
        return ResponseEntity.ok(activityService.getAllUserActivity());
    }

    @GetMapping("/user")
    public ResponseEntity<List<ActivityResponse>> getUserActivity(@RequestHeader(value = "X-user-ID") String userId) {
        return ResponseEntity.ok(activityService.getUserActivity(userId));
    }


}
