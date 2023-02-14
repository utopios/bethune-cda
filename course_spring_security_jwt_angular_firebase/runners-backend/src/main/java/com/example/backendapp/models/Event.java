package com.example.backendapp.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.nio.file.Path;
import java.sql.Blob;
import java.util.Date;

@Entity
@Table(name = "events")
@Getter
@Setter
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private Long eventId;

    @Column(name = "event_name")
    @NotNull
    private String eventName;


    @Column(name = "event_photo_url")
    @NotNull
    private String eventPhotoUrl;

    @Column(name = "event_description")
    private String eventDescription;

    @Column(name = "event_city")
    @NotNull
    private String eventCity;

    @Column(name = "event_country")
    @NotNull
    private String eventCountry;

    @Column(name = "event_date")
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "MM-dd-yyyy")
    @NotNull
    private Date eventDate;

    @Column(name = "event_registration_link")
    @NotNull
    private String eventRegistrationLink;

    @Column(name = "user_id")
    private Long userId;


    public Event(){}

    public Event(String eventName,String eventPhotoUrl, String eventDescription, String eventCity, String eventCountry, Date eventDate, String eventRegistrationLink, Long userId) {
        this.eventName = eventName;
        this.eventPhotoUrl = eventPhotoUrl;
        this.eventDescription = eventDescription;
        this.eventCity = eventCity;
        this.eventCountry = eventCountry;
        this.eventDate = eventDate;
        this.eventRegistrationLink = eventRegistrationLink;
        this.userId = userId;
    }
}
