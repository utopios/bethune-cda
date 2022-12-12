package com.example.tphopital.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Date;

@Data
@Entity
public class FichePayment extends FicheSoin {

    private Date datExigibilite;
    private Date datePayment;
    private double montantPayment;
    private boolean indicateurPayment;

    @ManyToOne
    @JoinColumn(name = "fiche_soin_id")
    private FicheSoin ficheSoin;
}
