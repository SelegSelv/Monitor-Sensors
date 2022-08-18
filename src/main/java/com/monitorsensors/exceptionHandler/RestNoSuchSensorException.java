package com.monitorsensors.exceptionHandler;

public class RestNoSuchSensorException extends RuntimeException{
    public RestNoSuchSensorException(String message) {
        super(message);
    }
}