package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "activity_categories")
public class ActivityCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String categoryName;

    private String description;

    private LocalDateTime createdAt;

    public ActivityCategory() {
    }

    @PrePersist
    public void prePersist() {
        if (this.categoryName == null || this.categoryName.isBlank()) {
            this.categoryName = "UNNAMED";
        }
        if (this.description == null) {
            this.description = "";
        }
        this.createdAt = LocalDateTime.now();
    }

    public long getId() {
        return id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
