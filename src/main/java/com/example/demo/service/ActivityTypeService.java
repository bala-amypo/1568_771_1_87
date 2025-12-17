package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.ActivityType;

public interface ActivityTypeService {
    ActivityType creatType(long categoryId,ActivityType type);
    ActivityType getType(long id);
    List<ActivityType> getTypesByCategory(long categortyId);
    
}
