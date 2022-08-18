package com.monitorsensors.controller;

import com.monitorsensors.dto.SensorRequestDto;
import com.monitorsensors.dto.SensorResponseDto;
import com.monitorsensors.exceptionHandler.RestNoSuchSensorException;
import com.monitorsensors.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SensorRestController {
    @Autowired
    private SensorService sensorService;

    @GetMapping("/sensors")
    public List<SensorResponseDto> allSensors(){
        return sensorService.getAllSensors();
    }
    @GetMapping("/sensors/{id}")
    public SensorResponseDto getSensor(@PathVariable int id){
        SensorResponseDto sensor=sensorService.getSensor(id);
        if(sensor==null){
            throw new RestNoSuchSensorException("Датчик с id = "+id+"не существует");
        }
        return sensor;
    }

    @PostMapping("/sensors")
    public SensorRequestDto addNewSensor(@RequestBody SensorRequestDto sensorRequestDto){
        sensorService.saveOrUpdateSensor(sensorRequestDto);
        return sensorRequestDto;
    }

    @PutMapping("/sensors")
    public SensorRequestDto updateSensor(@RequestBody SensorRequestDto sensorRequestDto){
        sensorService.saveOrUpdateSensor(sensorRequestDto);
        return sensorRequestDto;
    }
    @DeleteMapping("/sensors/{id}")
    public String deleteSensor(@PathVariable int id){
        SensorResponseDto sensorResponseDto=sensorService.getSensor(id);
        if(sensorResponseDto==null){
            throw new RestNoSuchSensorException("Датчик с id = "+id+"не существует");
        }
        sensorService.deleteSensor(id);
        return "Датчик с id = "+id+" удален";
    }
}
