package com.example.document_management_system.Model.Views;

import javax.persistence.*;

@Entity
@Table(name = "promeni_vo_celiot_period")
public class PromeniVoCeliotPeriod {

    @Id
    @Column(name = "id_klient")
    private Integer idKlient;
    @Column(name = "ime")
    private String ime;
    @Column(name = "vkupno_dostaveni_dokuemnti")
    private Long vkupnoDostaveniDokuemnti;
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

    public Long getVkupnoDostaveniDokuemnti() {
        return vkupnoDostaveniDokuemnti;
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
