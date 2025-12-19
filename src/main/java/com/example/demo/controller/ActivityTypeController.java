package com.example.demo.controller;

import com.example.demo.entity.ActivityType;
import com.example.demo.service.ActivityTypeService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/types")
public class ActivityTypeController {

    private final ActivityTypeService typeService;

    public ActivityTypeController(ActivityTypeService typeService) {
        this.typeService = typeService;
    }

    @PostMapping("/category/{categoryId}")
    public ActivityType createType(@PathVariable long categoryId, @RequestBody ActivityType type) {
        return typeService.createType(categoryId, type);
    }

    @GetMapping("/{id}")
    public ActivityType getType(@PathVariable long id) {
        return typeService.getType(id);
    }

    @GetMapping("/category/{categoryId}")
    public List<ActivityType> getTypesByCategory(@PathVariable long categoryId) {
        return typeService.getTypesByCategory(categoryId);
    }
}
