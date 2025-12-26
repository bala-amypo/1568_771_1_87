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
    public EmissionFactor createEmissionFactor(Long activityTypeId, EmissionFactor factor) {
        ActivityType activityType = activityTypeRepository.findById(activityTypeId)
                .orElseThrow(() -> new RuntimeException("ActivityType not found"));

        if (factor.getFactorValue() <= 0) {
            throw new IllegalArgumentException("Invalid emission factor");
        }

        factor.setActivityType(activityType);
        return emissionFactorRepository.save(factor);
    }

    @Override
    public List<EmissionFactor> getAllEmissionFactors() {
        return emissionFactorRepository.findAll();
    }

    @Override
    public EmissionFactor getEmissionFactorById(Long id) {
        return emissionFactorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("EmissionFactor not found"));
    }

    @Override
    public EmissionFactor updateEmissionFactor(Long id, EmissionFactor updatedFactor) {
        EmissionFactor existing = getEmissionFactorById(id);

        if (updatedFactor.getFactorValue() > 0) {
            existing.setFactorValue(updatedFactor.getFactorValue());
        }

        if (updatedFactor.getUnit() != null) {
            existing.setUnit(updatedFactor.getUnit());
        }

        return emissionFactorRepository.save(existing);
    }

    @Override
    public void deleteEmissionFactor(Long id) {
        emissionFactorRepository.deleteById(id);
    }
}
