package com.PratikC54.fitness_app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.hibernate.type.SqlTypes.JSON;

@Entity
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @JdbcTypeCode(JSON)
    @Column(columnDefinition = "json")
    private Map<String , Object> additionalMetrices;

    @Enumerated(EnumType.STRING)
    private ActivityType type;
    private Integer duration;
    private Integer caloriesBurned;
    private LocalDateTime startTime;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn( name = "user_id" , nullable = false , foreignKey = @ForeignKey(name = "fk_activity_name"))
@JsonIgnore
private User user;

@OneToMany(mappedBy = "activity" , cascade = CascadeType.ALL , orphanRemoval = true)
    @JsonIgnore
    private List<Recommendation> recommendations = new ArrayList<>();
}
