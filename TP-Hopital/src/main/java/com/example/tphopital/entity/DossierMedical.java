package com.example.tphopital.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "dossier_medical")
public class DossierMedical {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "date_creation")
    private Date dateCreaction;
    @Column(name ="code_access_patient")
    private String codeAccessPatient;

    @OneToMany
    private List<FicheSoin> ficheSoins;
}
