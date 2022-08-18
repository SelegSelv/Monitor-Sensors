package com.monitorsensors.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RestNoSuchSensorException.class)
    public ResponseEntity<SensorIncorrectId> restNoSuchFilmExceptionHandler(
            RestNoSuchSensorException exception){
        SensorIncorrectId data=new SensorIncorrectId();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }
}
