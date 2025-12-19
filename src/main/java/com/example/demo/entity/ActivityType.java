package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "activity_types")
public class ActivityType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String typeName;

    private String unit;

    @ManyToOne
    private ActivityCategory category;

    private LocalDateTime createdAt;

    public ActivityType() {
    }

    @PrePersist
    public void prePersist() {
        if (this.typeName == null || this.typeName.isBlank()) {
            this.typeName = "UNNAMED";
        }
        if (this.unit == null) {
            this.unit = "";
        }
        this.createdAt = LocalDateTime.now();
    }

    public long getId() {
        return id;
    }

    public String getTypeName() {
        return typeName;
    }

    public String getUnit() {
        return unit;
    }

    public ActivityCategory getCategory() {
        return category;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setCategory(ActivityCategory category) {
        this.category = category;
    }
}
