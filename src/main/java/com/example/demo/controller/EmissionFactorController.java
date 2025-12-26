package com.example.demo.controller;

import com.example.demo.entity.EmissionFactor;
import com.example.demo.service.EmissionFactorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/factors")
public class EmissionFactorController {

    private final EmissionFactorService factorService;

    public EmissionFactorController(EmissionFactorService factorService) {
        this.factorService = factorService;
    }

    @PostMapping("/{activityTypeId}")
    public EmissionFactor createFactor(@PathVariable long activityTypeId, @RequestBody EmissionFactor factor) {
        return factorService.createFactor(activityTypeId, factor);
    }

    @GetMapping("/{id}")
    public EmissionFactor getFactor(@PathVariable long id) {
        return factorService.getFactor(id);
    }

    @GetMapping("/type/{activityTypeId}")
    public EmissionFactor getFactorByType(@PathVariable long activityTypeId) {
        return factorService.getFactorByType(activityTypeId);
    }

    @GetMapping
    public List<EmissionFactor> getAllFactors() {
        return factorService.getAllFactors();
    }
}
