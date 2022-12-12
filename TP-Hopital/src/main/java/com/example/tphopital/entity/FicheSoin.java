package com.example.tphopital.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class FicheSoin {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
    private Date dateCreation;
    private String agentCreateur;
    private String adresseCreateur;

    @OneToMany(mappedBy = "ficheSoin")
    private List<FichePayment> fichePayments;
}
