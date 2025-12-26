package com.example.demo.service.impl;

import com.example.demo.entity.ActivityCategory;
import com.example.demo.entity.ActivityType;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.ValidationException;
import com.example.demo.repository.ActivityCategoryRepository;
import com.example.demo.repository.ActivityTypeRepository;

import java.util.List;

public class ActivityTypeServiceImpl {

    private final ActivityTypeRepository typeRepository;
    private final ActivityCategoryRepository categoryRepository;

    public ActivityTypeServiceImpl(ActivityTypeRepository typeRepository,
                                   ActivityCategoryRepository categoryRepository) {
        this.typeRepository = typeRepository;
        this.categoryRepository = categoryRepository;
    }

    public ActivityType createType(Long categoryId, ActivityType type) {

        ActivityCategory category = categoryRepository.findById(categoryId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Category not found"));

        if (type.getUnit() == null || type.getUnit().isBlank()) {
            throw new ValidationException("Unit is required");
        }

        type.setCategory(category);
        return typeRepository.save(type);
    }

    public ActivityType getType(Long id) {
        return typeRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Category not found"));
    }

    public List<ActivityType> getTypesByCategory(Long categoryId) {
        return typeRepository.findByCategory_Id(categoryId);
    }
}
