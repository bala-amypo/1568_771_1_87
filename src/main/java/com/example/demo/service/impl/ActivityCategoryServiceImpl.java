package com.example.demo.service.impl;

import com.example.demo.entity.ActivityCategory;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.ValidationException;
import com.example.demo.repository.ActivityCategoryRepository;

import java.util.List;

public class ActivityCategoryServiceImpl {

    private final ActivityCategoryRepository categoryRepository;

    public ActivityCategoryServiceImpl(ActivityCategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public ActivityCategory createCategory(ActivityCategory category) {
        if (categoryRepository.existsByCategoryName(category.getCategoryName())) {
            throw new ValidationException("Category name must be unique");
        }
        return categoryRepository.save(category);
    }

    public ActivityCategory getCategory(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Category not found"));
    }

    public List<ActivityCategory> getAllCategories() {
        return categoryRepository.findAll();
    }
}
