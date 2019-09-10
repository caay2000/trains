package com.github.caay2000.trains.model;

public class TrainsException extends RuntimeException {

    public TrainsException(String message) {
        super(message);
    }

    public TrainsException(String message, Throwable cause) {
        super(message, cause);
    }
}
