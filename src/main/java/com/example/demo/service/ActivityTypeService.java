package com.example.demo.service;

import com.example.demo.entity.ActivityType;
import java.util.List;

public interface ActivityTypeService {
    ActivityType createType(long categoryId, ActivityType type);
    ActivityType getType(long id);
    List<ActivityType> getTypesByCategory(long categoryId);
}
