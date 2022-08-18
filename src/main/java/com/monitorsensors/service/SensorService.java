package com.monitorsensors.service;

import com.monitorsensors.dto.SensorRequestDto;
import com.monitorsensors.dto.SensorResponseDto;

import java.util.List;

public interface SensorService {
    List<SensorResponseDto> getAllSensors();

    void saveOrUpdateSensor(SensorRequestDto sensor);

    SensorResponseDto getSensor(int id);

    void deleteSensor(int id);
    List<SensorResponseDto> searchForMatches(String s);
}
