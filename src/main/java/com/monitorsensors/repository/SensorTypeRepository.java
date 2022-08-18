package com.monitorsensors.repository;

import com.monitorsensors.entity.SensorType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorTypeRepository extends JpaRepository<SensorType,Integer> {
}
