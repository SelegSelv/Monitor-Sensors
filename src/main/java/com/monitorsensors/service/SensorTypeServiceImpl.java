package com.monitorsensors.service;

import com.monitorsensors.entity.SensorType;
import com.monitorsensors.repository.SensorTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorTypeServiceImpl implements SensorTypeService {
    @Autowired
    private SensorTypeRepository repository;

    @Override
    public List<SensorType> getAllSensorType() {
        return repository.findAll();
    }
}
