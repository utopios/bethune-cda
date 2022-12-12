package com.example.tphopital.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class FicheSoin {
    @Id
    private int id;
    private Date dateCreation;
    private String agentCreateur;
    private String adresseCreateur;

    @OneToMany(mappedBy = "ficheSoin")
    private List<FichePayment> fichePayments;
}
