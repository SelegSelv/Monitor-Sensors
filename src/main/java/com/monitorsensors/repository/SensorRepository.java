package com.monitorsensors.repository;

import com.monitorsensors.entity.Sensor;

import java.util.List;

public interface SensorRepository {
    List<Sensor> getAllSensors();

    void saveOrUpdateSensor(Sensor sensor);

    Sensor getSensor(int id);

    void deleteSensor(int id);

    List<Sensor> searchForMatches(String s);
}
