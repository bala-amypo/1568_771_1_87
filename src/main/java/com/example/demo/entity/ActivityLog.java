package com.example.demo.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ActivityLog {
    private long id;
    //activityType(Many-to-One)
    //user(Many-to-One)
    private double quantity;
    private LocalDate activityDate;
    private LocalDateTime loggedAt;
    private Double estimatedEmission;

    public ActivityLog(){}

    public ActivityLog(long id, double quantity, LocalDate activityDate, LocalDateTime loggedAt,
            Double estimatedEmission) {
        this.id = id;
        this.quantity = quantity;
        this.activityDate = activityDate;
        this.loggedAt = loggedAt;
        this.estimatedEmission = estimatedEmission;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public void setActivityDate(LocalDate activityDate) {
        this.activityDate = activityDate;
    }

    public void setLoggedAt(LocalDateTime loggedAt) {
        this.loggedAt = loggedAt;
    }

    public void setEstimatedEmission(Double estimatedEmission) {
        this.estimatedEmission = estimatedEmission;
    }

    public long getId() {
        return id;
    }

    public double getQuantity() {
        return quantity;
    }

    public LocalDate getActivityDate() {
        return activityDate;
    }

    public LocalDateTime getLoggedAt() {
        return loggedAt;
    }

    public Double getEstimatedEmission() {
        return estimatedEmission;
    }

    
}
