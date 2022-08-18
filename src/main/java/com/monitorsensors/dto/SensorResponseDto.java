package com.monitorsensors.dto;

public class SensorResponseDto {

    private int id;
    private String title;
    private String model;
    private Range fromTo;
    private String type;
    private String unit;
    private String location;

    public SensorResponseDto(int id,String title, String model, Range fromTo, String type, String unit, String location) {
        this.id=id;
        this.title = title;
        this.model = model;
        this.fromTo = fromTo;
        this.type = type;
        this.unit = unit;
        this.location = location;
    }

    public SensorResponseDto(String title, String model, Range fromTo, String type, String unit, String location) {
        this.title = title;
        this.model = model;
        this.fromTo = fromTo;
        this.type = type;
        this.unit = unit;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getModel() {
        return model;
    }

    public Range getFromTo() {
        return fromTo;
    }

    public String getType() {
        return type;
    }

    public String getUnit() {
        return unit;
    }

    public String getLocation() {
        return location;
    }

}
