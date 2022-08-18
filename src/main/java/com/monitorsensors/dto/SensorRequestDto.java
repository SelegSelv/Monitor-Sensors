package com.monitorsensors.dto;




import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


public class SensorRequestDto {
    private int id;
    @NotBlank(message = "Укажите имя")
    @Size(max = 30,message = "Имя не должно превышать 30 символов")
    private String title;
    @NotBlank(message = "Укажите модель")
    @Size(max = 15,message = "Название модели не должно превышать 10 символов")
    private String model;


    private Range fromTo;
    @NotBlank(message = "Укажите тип")
    private String type;
    private String unit;
    @Size(max = 40,message = "Название местоположения не должно превышать 40 символов")

    private String location;
    @Size(max = 200,message = "Описание не должно превышать 200 символов")
    private String description;

    public SensorRequestDto(String title, String model, Range fromTo, String type, String unit, String location, String description) {
        this.title = title;
        this.model = model;
        this.fromTo = fromTo;
        this.type = type;
        this.unit = unit;
        this.location = location;
        this.description = description;
    }

    public SensorRequestDto(int id, String title, String model, Range fromTo, String type, String unit, String location, String description) {
        this.id = id;
        this.title = title;
        this.model = model;
        this.fromTo = fromTo;
        this.type = type;
        this.unit = unit;
        this.location = location;
        this.description = description;
    }

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
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

    public void setFromTo(Range fromTo) {
        this.fromTo = fromTo;
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

    public String getDescription() {
        return description;
    }
}
