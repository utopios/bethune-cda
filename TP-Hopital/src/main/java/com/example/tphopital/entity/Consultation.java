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
@Table(name = "consultation")
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "date_consultation")
    private Date dateConsultation;
    private String heure;
    private String lieu;
    @Column(name = "etat_consultation")
    private char etatConsultation;

    @OneToOne
    @JoinColumn(name = "fiche_consultation_id")
    private FicheConsultation ficheConsultation;

}
