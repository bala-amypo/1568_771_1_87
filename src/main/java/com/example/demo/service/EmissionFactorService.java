package com.example.demo.service;

import com.example.demo.entity.EmissionFactor;
import java.util.List;

public interface EmissionFactorService {
    EmissionFactor createFactor(long activityTypeId, EmissionFactor factor);
    EmissionFactor getFactor(long id);
    EmissionFactor getFactorByType(long typeId);
    List<EmissionFactor> getAllFactors();
}
