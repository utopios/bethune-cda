package com.example.tphopital.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
@Data
public class FicheConsultation extends FicheSoin {

    private String compteRendu;

    @OneToMany
    private List<Prescription> prescriptions;

    //@OneToOne
    //private Consultation consultation;
}
