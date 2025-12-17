package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.EmissionFactor;

public interface EmissionFactorService {
    EmissionFactor createFactor(long activityTypeId,EmissionFactor factor);
    EmissionFactor getFactor(long id);
    EmissionFactor getFactorByType(long typeId);
    List<EmissionFactor> getAllFactors();
}
