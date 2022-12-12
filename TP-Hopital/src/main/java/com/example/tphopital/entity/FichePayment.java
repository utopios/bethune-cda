package com.example.tphopital.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "fiche_payment")
public class FichePayment extends FicheSoin {

    @Column(name = "date_exigibilite")
    private Date datExigibilite;
    @Column(name = "date_payement")
    private Date datePayment;
    @Column(name = "montant_payment")
    private double montantPayment;
    @Column(name = "indicateur_payment")
    private boolean indicateurPayment;

    @ManyToOne
    @JoinColumn(name = "fiche_soin_id")
    private FicheSoin ficheSoin;
}
