package com.example.demo.entity;

import java.time.LocalDateTime;

public class ActivityType {
    private long id;
    private String categoryName;
    private String unit;
    //category(Many-to-One)
    private LocalDateTime createdAt;

    public ActivityType(){}

    public ActivityType(long id, String categoryName, String unit, LocalDateTime createdAt) {
        this.id = id;
        this.categoryName = categoryName;
        this.unit = unit;
        this.createdAt = createdAt;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
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

    public String getCategoryName() {
        return categoryName;
    }

    public String getUnit() {
        return unit;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    
}
