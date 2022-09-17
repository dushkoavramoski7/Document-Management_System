package com.example.document_management_system.Model.Views;

import javax.persistence.*;

@Entity
@Table(name = "vraboten_kolku_rns_promenil")
public class VrabotenKolkuRnsPromenil {
    @Id
    @Column(name = "id_vraboten")
    private int id_vraboten;
    @Column(name = "ime_vraboten")
    private String imeVraboten;
    @Column(name = "prezime_vraboten")
    private String prezimeVraboten;
    @Column(name = "ime_oddel")
    private String imeOddel;
    @Column(name = "izvrsena_promena_vrz_rekordi_na_sledenje")
    private Long izvrsenaPromenaVrzRekordiNaSledenje;

    public String getImeVraboten() {
        return imeVraboten;
    }

    public String getPrezimeVraboten() {
        return prezimeVraboten;
    }

    public String getImeOddel() {
        return imeOddel;
    }

    public Long getIzvrsenaPromenaVrzRekordiNaSledenje() {
        return izvrsenaPromenaVrzRekordiNaSledenje;
    }
}
