package com.example.backendapp.controllers;

import com.example.backendapp.models.Event;
import com.example.backendapp.payload.response.MessageResponse;
import com.example.backendapp.services.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping(value = "/add-event", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addEvent(@RequestBody Event event) throws IOException, SQLException {
        this.eventService.saveEvent(event);
        return ResponseEntity.ok(new MessageResponse("Event successfully added!"));
    }

    @GetMapping("/events")
    public List<Event> getAllEvents() {
        return this.eventService.getAllEvents();
    }

    @GetMapping("/events/{userId}")
    public List<Event> getEventsByUserId(@PathVariable Long userId) {
        return this.eventService.getEventsByUserId(userId);
    }

    @GetMapping("/getEvent/{eventId}")
    public Optional<Event> getEventById(@PathVariable Long eventId) {
        return this.eventService.getEventById(eventId);
    }

    @PutMapping("/update-event/{eventId}")
    public ResponseEntity<?> updateEvent(@PathVariable Long eventId, @RequestBody Event event) {
        this.eventService.updateEvent(eventId,event);
        return ResponseEntity.ok(new MessageResponse("Event successfully updated!"));
    }

    @DeleteMapping("/delete-event/{eventId}")
    public void deleteEvent(@PathVariable Long eventId) {
        this.eventService.deleteEvent(eventId);
    }

    @GetMapping("cities")
    public List<String> getAllEventCities() {
        return this.eventService.getAllEventCities();
    }

    @GetMapping("/getAllEventsForCity/{eventCity}")
    public List<Event> getAllEventsForCity(@PathVariable String eventCity) {
        return this.eventService.getAllEventsForCity(eventCity);
    }
}
