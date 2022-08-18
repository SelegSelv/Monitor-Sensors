package com.monitorsensors.service;

import com.monitorsensors.dto.Range;
import com.monitorsensors.dto.SensorRequestDto;
import com.monitorsensors.dto.SensorResponseDto;
import com.monitorsensors.entity.Sensor;
import com.monitorsensors.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@Transactional
public class SensorServiceImpl implements SensorService{

    @Autowired
    private SensorRepository sensorRepository;

    @Override
    public List<SensorResponseDto> getAllSensors() {
        List<Sensor> allSensors = sensorRepository.getAllSensors();
        List<SensorResponseDto>sensorResponseDto=new ArrayList<>();
        for(Sensor sensor:allSensors){
            Range range=new Range();
            range.setFrom(sensor.getRangeFrom());
            range.setTo(sensor.getRangeTo());
            sensorResponseDto.add(new SensorResponseDto(sensor.getId(),sensor.getTitle(),sensor.getModel(),
                    range,sensor.getType(),sensor.getUnit(),sensor.getLocation()));
        }
        return sensorResponseDto;
    }

    @Override
    public void saveOrUpdateSensor(SensorRequestDto sensor) {

        sensorRepository.saveOrUpdateSensor(new Sensor(sensor.getId(),sensor.getTitle(),sensor.getModel(),sensor.getFromTo().getFrom(),
                sensor.getFromTo().getTo(),sensor.getType(),sensor.getUnit(),sensor.getLocation(),sensor.getDescription()));
    }

    @Override
    public SensorResponseDto getSensor(int id) {
        Sensor sensor = sensorRepository.getSensor(id);
        Range range=new Range();
        range.setFrom(sensor.getRangeFrom());
        range.setTo(sensor.getRangeTo());
        SensorResponseDto sensorResponseDto=new SensorResponseDto(sensor.getId(),sensor.getTitle(),sensor.getModel(),
                range,sensor.getType(),sensor.getUnit(),sensor.getLocation());
        return sensorResponseDto;
    }

    @Override
    public void deleteSensor(int id) {
        sensorRepository.deleteSensor(id);
    }

    @Override
    public List<SensorResponseDto> searchForMatches(String s) {
        List<Sensor> sensors = sensorRepository.searchForMatches(s);
        Pattern pattern=Pattern.compile("(\\w*)"+s+"(\\w*)",Pattern.CASE_INSENSITIVE);
        List<SensorResponseDto> result=new ArrayList<>();
        for(Sensor sensor:sensors){
            Matcher matcher1=pattern.matcher(sensor.getTitle());
            Matcher matcher2=pattern.matcher(sensor.getModel());
            Matcher matcher3=pattern.matcher(sensor.getDescription());
            if (matcher1.find()||matcher2.find()||matcher3.find()){
                Range range=new Range(sensor.getRangeFrom(),sensor.getRangeTo());
                result.add(new SensorResponseDto(sensor.getTitle(),sensor.getModel(),range,
                        sensor.getType(),sensor.getUnit(),sensor.getLocation()));
            }
        }
        return result;
    }
}
