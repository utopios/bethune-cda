package com.example.correctionhotel.entity;

import com.example.correctionhotel.util.enums.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Reservation {
    @Id
    private int id;
    private Status status;

    @ManyToMany
    private List<Room> rooms;

    @ManyToOne
    private Customer customer;
}


