package com.example.demo.controller;

import com.example.demo.entity.EmissionFactor;
import com.example.demo.service.impl.EmissionFactorServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/factors")
public class EmissionFactorController {

    private final EmissionFactorServiceImpl factorService;

    public EmissionFactorController(EmissionFactorServiceImpl factorService) {
        this.factorService = factorService;
    }

    @PostMapping("/type/{typeId}")
    public EmissionFactor createFactor(@PathVariable Long typeId,
                                       @RequestBody EmissionFactor factor) {
        return factorService.createFactor(typeId, factor);
    }

    @GetMapping("/{id}")
    public EmissionFactor getFactor(@PathVariable Long id) {
        return factorService.getFactor(id);
    }

    @GetMapping("/type/{typeId}")
    public EmissionFactor getByType(@PathVariable Long typeId) {
        return factorService.getFactorByType(typeId);
    }

    @GetMapping
    public List<EmissionFactor> getAll() {
        return factorService.getAllFactors();
    }
}
