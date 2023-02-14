package com.example.backendapp.services.impl;

import com.example.backendapp.models.Event;
import com.example.backendapp.models.exceptions.EventNotExist;
import com.example.backendapp.repository.EventRepository;
import com.example.backendapp.services.EventService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public Event saveEvent(Event event)  {
        Event newEvent = new Event();
        newEvent.setEventName(event.getEventName());
        newEvent.setEventPhotoUrl(event.getEventPhotoUrl());
        newEvent.setEventDescription(event.getEventDescription());
        newEvent.setEventCity(event.getEventCity());
        newEvent.setEventCountry(event.getEventCountry());
        newEvent.setEventDate(event.getEventDate());
        newEvent.setEventRegistrationLink(event.getEventRegistrationLink());
        newEvent.setUserId(event.getUserId());
        return eventRepository.save(newEvent);
    }

    @Override
    public List<Event> getAllEvents() {
        return this.eventRepository.findAll();
    }

    @Override
    public List<Event> getEventsByUserId(Long userId) {
        return this.eventRepository.findEventByUserId(userId);
    }

    @Override
    public Optional<Event> getEventById(Long eventId) {
        return this.eventRepository.findById(eventId);
    }

    @Override
    public Event updateEvent(Long eventId, Event event) {
        Event eventForUpdate = this.eventRepository.findById(eventId).orElseThrow(() -> new EventNotExist(eventId));
        eventForUpdate.setEventName(event.getEventName());
        // if we updated the event with new photo
        if (event.getEventPhotoUrl() != null) {
            eventForUpdate.setEventPhotoUrl(event.getEventPhotoUrl());
        }
        eventForUpdate.setEventDescription(event.getEventDescription());
        eventForUpdate.setEventCity(event.getEventCity());
        eventForUpdate.setEventCountry(event.getEventCountry());
        eventForUpdate.setEventDate(event.getEventDate());
        eventForUpdate.setEventRegistrationLink(event.getEventRegistrationLink());
        eventForUpdate.setUserId(event.getUserId());
        return this.eventRepository.save(eventForUpdate);


    }

    @Override
    public void deleteEvent(Long eventId) {
        this.eventRepository.deleteById(eventId);

    }

    @Override
    public List<String> getAllEventCities() {
        return this.eventRepository.getAllEventCities();
    }

    @Override
    public List<Event> getAllEventsForCity(String eventCity) {
        return this.eventRepository.getAllByEventCity(eventCity);
    }


}
