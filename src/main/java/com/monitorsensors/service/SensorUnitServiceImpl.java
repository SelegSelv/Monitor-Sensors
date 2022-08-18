package com.monitorsensors.service;

import com.monitorsensors.entity.SensorUnit;
import com.monitorsensors.repository.SensorUnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorUnitServiceImpl implements SensorUnitService{

    @Autowired
    private SensorUnitRepository repository;
    @Override
    public List<SensorUnit> getAllSensorUnit() {
        return repository.findAll();
    }
}
