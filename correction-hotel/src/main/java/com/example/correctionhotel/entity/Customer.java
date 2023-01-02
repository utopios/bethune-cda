package com.example.correctionhotel.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Customer {
    @Id
    private int id;
    private String firstName;
    private String lastName;
    private String phone;

    @OneToMany
    private List<Reservation> reservations;
}
