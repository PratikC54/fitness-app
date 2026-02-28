package com.PratikC54.fitness_app.repository;

import com.PratikC54.fitness_app.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<Activity , String> {
    List<Activity> findByUserId(String userId);
}
