package com.example.demo.controller;

import com.example.demo.entity.ActivityCategory;
import com.example.demo.service.impl.ActivityCategoryServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class ActivityCategoryController {

    private final ActivityCategoryServiceImpl categoryService;

    public ActivityCategoryController(ActivityCategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ActivityCategory create(@RequestBody ActivityCategory category) {
        return categoryService.createCategory(category);
    }

    @GetMapping
    public List<ActivityCategory> getAll() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public ActivityCategory getById(@PathVariable Long id) {
        return categoryService.getCategory(id);
    }
}
