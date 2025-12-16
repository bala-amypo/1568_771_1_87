package com.example.demo.entity;

import java.time.LocalDateTime;

public class EmissionFactor {
    private long id;
    //activityType(One-to-One or Many-to-One)
    private double factorValue;
    private String unit;
    private LocalDateTime createdAt;

    public EmissionFactor(){}

    public EmissionFactor(long id, double factorValue, String unit, LocalDateTime createdAt) {
        this.id = id;
        this.factorValue = factorValue;
        this.unit = unit;
        this.createdAt = createdAt;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFactorValue(double factorValue) {
        this.factorValue = factorValue;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public long getId() {
        return id;
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

    
}
