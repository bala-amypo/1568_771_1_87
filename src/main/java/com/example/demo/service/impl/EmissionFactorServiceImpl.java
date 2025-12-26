package com.example.demo.service.impl;

import com.example.demo.entity.ActivityType;
import com.example.demo.entity.EmissionFactor;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.ValidationException;
import com.example.demo.repository.ActivityTypeRepository;
import com.example.demo.repository.EmissionFactorRepository;

import java.util.List;

public class EmissionFactorServiceImpl {

    private final EmissionFactorRepository factorRepository;
    private final ActivityTypeRepository typeRepository;

    public EmissionFactorServiceImpl(EmissionFactorRepository factorRepository,
                                     ActivityTypeRepository typeRepository) {
        this.factorRepository = factorRepository;
        this.typeRepository = typeRepository;
    }

    public EmissionFactor createFactor(Long activityTypeId, EmissionFactor factor) {

        ActivityType type = typeRepository.findById(activityTypeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Category not found"));

        if (factor.getFactorValue() == null || factor.getFactorValue() <= 0) {
            throw new ValidationException("Factor value must be greater than zero");
        }

        factor.setActivityType(type);
        return factorRepository.save(factor);
    }

    public EmissionFactor getFactor(Long id) {
        return factorRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Emission factor not found"));
    }

    public EmissionFactor getFactorByType(Long typeId) {
        return factorRepository.findByActivityType_Id(typeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Emission factor not found"));
    }

    public List<EmissionFactor> getAllFactors() {
        return factorRepository.findAll();
    }
}
