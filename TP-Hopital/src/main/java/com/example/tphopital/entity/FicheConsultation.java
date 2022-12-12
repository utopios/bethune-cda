package com.example.tphopital.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "fiche_consultation")
public class FicheConsultation extends FicheSoin {

    @Column(name ="compte_rendu")
    private String compteRendu;

    @OneToMany
    private List<Prescription> prescriptions;

    //@OneToOne
    //private Consultation consultation;
}
