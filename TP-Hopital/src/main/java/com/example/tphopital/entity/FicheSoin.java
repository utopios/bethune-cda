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
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "fiche_soin")
public class FicheSoin {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
    @Column(name ="date_creation")
    private Date dateCreation;
    @Column(name = "agent_createur")
    private String agentCreateur;
    @Column(name = "adresse_createur")
    private String adresseCreateur;

    @OneToMany(mappedBy = "ficheSoin")
    private List<FichePayment> fichePayments;
}
