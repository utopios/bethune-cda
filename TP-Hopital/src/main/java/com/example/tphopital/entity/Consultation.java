package com.example.tphopital.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date dateConsultation;
    private String heure;
    private String lieu;
    private char etatConsultation;

    @OneToOne
    private FicheConsultation ficheConsultation;

}
