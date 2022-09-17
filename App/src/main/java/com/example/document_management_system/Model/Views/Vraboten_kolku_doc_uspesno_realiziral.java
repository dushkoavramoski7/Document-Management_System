package com.example.document_management_system.Model.Views;


import org.hibernate.annotations.Immutable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Immutable
@Table(name="vraboten_kolku_dokumenti_uspesno_realiziral")
public class Vraboten_kolku_doc_uspesno_realiziral {
    @Id
    private int id_vraboten;
    private String ime_vraboten;
    private String prezime_vraboten;
    private String ime_oddel;
    private Long dostaveni_dokumenti_na_vrabotenit_vo_oddelot;
    private Long realizirani_baranja_od_vraboteniot_vo_oddelot;

    public int getId_vraboten() {
        return id_vraboten;
    }

    public String getIme_vraboten() {
        return ime_vraboten;
    }

    public String getPrezime_vraboten() {
        return prezime_vraboten;
    }

    public String getIme_oddel() {
        return ime_oddel;
    }

    public Long getDostaveni_dokumenti_na_vraboteniot_vo_oddelot() {
        return dostaveni_dokumenti_na_vrabotenit_vo_oddelot;
    }

    public Long getRealizirani_baranja_od_vraboteniot_vo_oddelot() {
        return realizirani_baranja_od_vraboteniot_vo_oddelot;
    }
}
