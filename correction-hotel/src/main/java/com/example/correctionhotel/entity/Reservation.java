package com.example.correctionhotel.entity;

import com.example.correctionhotel.util.enums.Status;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "reservation")
public class Reservation {
    @Id
    private int id;
    private Status status;

    @ManyToMany
    @JoinTable(
            name = "reservation_room",
            joinColumns = {@JoinColumn(name = "reservation_id")},
            inverseJoinColumns = {@JoinColumn(name = "room_id")}
    )
    private List<Room> rooms;

    @ManyToOne
    private Customer customer;
}


