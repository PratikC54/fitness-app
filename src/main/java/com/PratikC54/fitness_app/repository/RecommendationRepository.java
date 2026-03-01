package com.PratikC54.fitness_app.repository;

import com.PratikC54.fitness_app.model.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecommendationRepository extends JpaRepository<Recommendation, String> {

    List<Recommendation> findByActivityId(String activityId);

    List<Recommendation> findByUserId(String userId);
}
