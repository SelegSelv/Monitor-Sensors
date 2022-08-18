package com.monitorsensors.repository;

import com.monitorsensors.entity.SensorUnit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorUnitRepository extends JpaRepository<SensorUnit,Integer> {
}
