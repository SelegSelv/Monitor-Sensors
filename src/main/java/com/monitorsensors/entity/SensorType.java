package com.monitorsensors.entity;

import javax.persistence.*;

@Entity
@Table(name = "sensor_type")
public class SensorType { @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "type")
    private String type;

    public SensorType() {
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }
}
