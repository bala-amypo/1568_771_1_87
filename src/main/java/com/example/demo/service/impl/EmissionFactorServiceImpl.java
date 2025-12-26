package com.example.demo.service.impl;

import com.example.demo.entity.ActivityType;
import com.example.demo.entity.EmissionFactor;
import com.example.demo.repository.ActivityTypeRepository;
import com.example.demo.repository.EmissionFactorRepository;
import com.example.demo.service.EmissionFactorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmissionFactorServiceImpl implements EmissionFactorService {

    private final EmissionFactorRepository emissionFactorRepository;
    private final ActivityTypeRepository activityTypeRepository;

    public EmissionFactorServiceImpl(EmissionFactorRepository emissionFactorRepository,
                                     ActivityTypeRepository activityTypeRepository) {
        this.emissionFactorRepository = emissionFactorRepository;
        this.activityTypeRepository = activityTypeRepository;
    }

    @Override
    public EmissionFactor createFactor(Long activityTypeId, EmissionFactor factor) {
        ActivityType activityType = activityTypeRepository.findById(activityTypeId)
                .orElseThrow(() -> new RuntimeException("ActivityType not found"));

        if (factor.getFactorValue() <= 0) {
            throw new IllegalArgumentException("Invalid factor value");
        }

        factor.setActivityType(activityType);
        return emissionFactorRepository.save(factor);
    }

    @Override
    public EmissionFactor getFactor(Long id) {
        return emissionFactorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("EmissionFactor not found"));
    }

    @Override
    public EmissionFactor getFactorByType(Long activityTypeId) {
        return emissionFactorRepository.findAll()
                .stream()
                .filter(f -> f.getActivityType() != null
                        && f.getActivityType().getId().equals(activityTypeId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("EmissionFactor not found for activity type"));
    }

    @Override
    public List<EmissionFactor> getAllFactors() {
        return emissionFactorRepository.findAll();
    }

    @Override
    public EmissionFactor updateFactor(Long id, EmissionFactor updatedFactor) {
        EmissionFactor existing = getFactor(id);

        if (updatedFactor.getFactorValue() > 0) {
            existing.setFactorValue(updatedFactor.getFactorValue());
        }

        if (updatedFactor.getUnit() != null) {
            existing.setUnit(updatedFactor.getUnit());
        }

        return emissionFactorRepository.save(existing);
    }

    @Override
    public void deleteFactor(Long id) {
        emissionFactorRepository.deleteById(id);
    }
}
