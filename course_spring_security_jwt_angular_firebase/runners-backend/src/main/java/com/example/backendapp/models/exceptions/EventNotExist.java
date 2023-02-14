package com.example.backendapp.models.exceptions;

public class EventNotExist extends RuntimeException {
    public EventNotExist(Long eventId) {
        super(String.format("Event with %d not exist", eventId));
    }
}
