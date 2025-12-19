package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "activity_logs")
public class ActivityLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private ActivityType activityType;

    private double quantity;

    private LocalDate activityDate;

    private double estimatedEmission;

    private LocalDateTime loggedAt;

    public ActivityLog() {
    }

    @PrePersist
    public void prePersist() {
        if (this.activityDate == null) {
            this.activityDate = LocalDate.now();
        }
        this.loggedAt = LocalDateTime.now();
    }

    public long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public ActivityType getActivityType() {
        return activityType;
    }

    public double getQuantity() {
        return quantity;
    }

    public LocalDate getActivityDate() {
        return activityDate;
    }

    public double getEstimatedEmission() {
        return estimatedEmission;
    }

    public LocalDateTime getLoggedAt() {
        return loggedAt;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public void setActivityDate(LocalDate activityDate) {
        this.activityDate = activityDate;
    }

    public void setEstimatedEmission(double estimatedEmission) {
        this.estimatedEmission = estimatedEmission;
    }
}
