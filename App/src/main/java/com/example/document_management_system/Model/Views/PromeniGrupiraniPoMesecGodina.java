package com.example.document_management_system.Model.Views;

import com.example.document_management_system.Model.Composite_Primary_Keys.KlientMesecGodina;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.Month;

@Entity
@Table(name = "promeni_grupirani_po_mesec_godina")
@IdClass(KlientMesecGodina.class)
public class PromeniGrupiraniPoMesecGodina {


    @Id
    @Column(name = "id_klient")
    private Integer idKlient;
    @Column(name = "ime")
    private String ime;
    @Id
    @Column(name = "mesec")
    private BigInteger mesec;
    @Id
    @Column(name = "godina")
    private BigInteger godina;
    @Column(name = "vkupno_dostaveni_dokuemnti_vo_mesecot")
    private Long vkupnoDostaveniDokuemntiVoMesecot;
    @Column(name = "realizirani_baranja")
    private Long realiziraniBaranja;
    @Column(name = "dokumenti_vo_obrabotka")
    private Long dokumentiVoObrabotka;
    @Column(name = "dostaven_odgovor_na_baranjeto")
    private Long dostavenOdgovorNaBaranjeto;
    @Column(name = "podneseni_baranja")
    private Long podneseniBaranja;


    public Integer getIdKlient() {
        return idKlient;
    }

    public String getIme() {
        return ime;
    }

    public BigInteger getMesec() {
        return mesec;
    }
    public String Month(){   // mesec vo string JAVA
        return Month.of(mesec.intValue()).name();
    }
    public BigInteger getGodina() {
        return godina;
    }

    public Long getVkupnoDostaveniDokuemntiVoMesecot() {
        return vkupnoDostaveniDokuemntiVoMesecot;
    }

    public Long getRealiziraniBaranja() {
        return realiziraniBaranja;
    }

    public Long getDokumentiVoObrabotka() {
        return dokumentiVoObrabotka;
    }

    public Long getDostavenOdgovorNaBaranjeto() {
        return dostavenOdgovorNaBaranjeto;
    }

    public Long getPodneseniBaranja() {
        return podneseniBaranja;
    }
}
