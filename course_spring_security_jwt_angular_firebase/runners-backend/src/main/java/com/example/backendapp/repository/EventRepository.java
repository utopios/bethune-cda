package com.example.backendapp.repository;

import com.example.backendapp.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event,Long> {

    List<Event> findEventByUserId(Long userId);

    @Query("SELECT event.eventCity from Event event")
    List<String> getAllEventCities();

    List<Event> getAllByEventCity(String eventCity);


}
