package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.ActivityCategory;

public interface ActivityCategoryService{
    public ActivityCategory createCategory(ActivityCategory category);
    public ActivityCategory getCategory(long id);
    List<ActivityCategory> getAllCategories();
}