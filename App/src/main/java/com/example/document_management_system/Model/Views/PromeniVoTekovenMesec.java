package com.example.document_management_system.Model.Views;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.Month;

@Entity
@Table(name = "promeni_vo_tekoven_mesec")
public class PromeniVoTekovenMesec {

    @Id
    @Column(name = "id_klient")
    private Integer idKlient;
    @Column(name = "ime")
    private String ime;
    @Column(name = "tekoven_mesec")
    private BigInteger tekovenMesec;
    @Column(name = "tekovna_godina")
    private BigInteger tekovnaGodina;
    @Column(name = "dostaveni_dokuemnti_vo_tekoven_mesec")
    private Long dostaveniDokuemntiVoTekovenMesec;
    @Column(name = "realizirani_baranja")
    private Long realiziraniBaranja;
    @Column(name = "dokumenti_vo_obrabotka")
    private Long dokumentiVoObrabotka;
    @Column(name = "dostaven_odgovor")
    private Long dostavenOdgovor;
    @Column(name = "podneseni_baranja")
    private Long podneseniBaranja;

    public Integer getIdKlient() {
        return idKlient;
    }

    public String getIme() {
        return ime;
    }

    public BigInteger getTekovenMesec() {
        return tekovenMesec;
    }
    public String Month(){   // tekoven mesec vo string JAVA 8
        return Month.of(tekovenMesec.intValue()).name();
    }

    public BigInteger getTekovnaGodina() {
        return tekovnaGodina;
    }

    public Long getDostaveniDokuemntiVoTekovenMesec() {
        return dostaveniDokuemntiVoTekovenMesec;
    }

    public Long getRealiziraniBaranja() {
        return realiziraniBaranja;
    }

    public Long getDokumentiVoObrabotka() {
        return dokumentiVoObrabotka;
    }

    public Long getDostavenOdgovor() {
        return dostavenOdgovor;
    }

    public Long getPodneseniBaranja() {
        return podneseniBaranja;
    }
}
