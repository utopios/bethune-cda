package com.example.backendapp.services;

import com.example.backendapp.models.Event;

import java.util.List;
import java.util.Optional;

public interface EventService {

    Event saveEvent(Event event);

    List<Event> getAllEvents();

    List<Event> getEventsByUserId(Long userId);

    Optional<Event> getEventById(Long eventId);

    Event updateEvent(Long eventId, Event event);

    void deleteEvent(Long eventId);

    List<String> getAllEventCities();

    List<Event> getAllEventsForCity(String eventCity);

}
