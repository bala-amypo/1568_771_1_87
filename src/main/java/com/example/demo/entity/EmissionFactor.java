package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "emission_factors")
public class EmissionFactor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private ActivityType activityType;

    private double factorValue;

    private String unit;

    private LocalDateTime createdAt;

    public EmissionFactor() {
    }

    @PrePersist
    public void prePersist() {
        if (this.unit == null) {
            this.unit = "";
        }
        this.createdAt = LocalDateTime.now();
    }

    public long getId() {
        return id;
    }

    public ActivityType getActivityType() {
        return activityType;
    }

    public double getFactorValue() {
        return factorValue;
    }

    public String getUnit() {
        return unit;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
    }

    public void setFactorValue(double factorValue) {
        this.factorValue = factorValue;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
