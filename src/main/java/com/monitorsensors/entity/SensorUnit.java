package com.monitorsensors.entity;

import javax.persistence.*;

@Entity
@Table(name = "sensor_unit")
public class SensorUnit { @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id")
private int id;
    @Column(name = "unit")
    private String unit;

    public SensorUnit() {
    }

    public int getId() {
        return id;
    }

    public String getUnit() {
        return unit;
    }
}