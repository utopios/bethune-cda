package com.example.tphopital.entity;

import com.example.tphopital.exception.StringFormatException;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nss;
    private String nom;
    private String prenom;
    @Column(name = "date_naissance")
    private Date dateNaissance;
    private char sexe;
    private String adresse;
    @Column(name = "numero_telephone")
    private String numeroTelephone;

    @OneToOne
    @JoinColumn(name = "dossier_medical_id")
    DossierMedical dossierMedical;

    public void setNom(String nom) throws StringFormatException {
        if(nom != null && nom.length() > 2)
            this.nom = nom;
        else
            throw new StringFormatException();
    }
}
