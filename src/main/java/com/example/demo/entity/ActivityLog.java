package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class ActivityLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private ActivityType activityType;

    @ManyToOne
    private User user;

    private Double quantity;

    private LocalDate activityDate;

    private LocalDateTime loggedAt;

    private Double estimatedEmission;

    public ActivityLog() {}

    public ActivityLog(Long id, ActivityType activityType, User user, Double quantity,
                       LocalDate activityDate, LocalDateTime loggedAt, Double estimatedEmission) {
        this.id = id;
        this.activityType = activityType;
        this.user = user;
        this.quantity = quantity;
        this.activityDate = activityDate;
        this.loggedAt = loggedAt;
        this.estimatedEmission = estimatedEmission;
    }

    @PrePersist
    public void prePersist() {
        this.loggedAt = LocalDateTime.now();
    }

    // getters & setters
    public Double getQuantity() { return quantity; }
    public void setQuantity(Double quantity) { this.quantity = quantity; }
    public void setActivityDate(LocalDate activityDate) { this.activityDate = activityDate; }
    public Double getEstimatedEmission() { return estimatedEmission; }
    public void setEstimatedEmission(Double estimatedEmission) { this.estimatedEmission = estimatedEmission; }
    public ActivityType getActivityType() { return activityType; }
    public User getUser() { return user; }
}
