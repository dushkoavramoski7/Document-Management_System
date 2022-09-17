package com.example.document_management_system.Model.Views;

import com.example.document_management_system.Model.Enum.DocumentStatus;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Immutable
@Table(name="detialview_log")
public class detailedView_log {

    @Id
    private int id_rekord;
    private int id_klient;
    private String ime;
    private String kompanija;
    private int id_dokument;
    private String predmet_na_dokument;
    private LocalDateTime datum_primen;
    private String dostaven_file_od_klient;
    private LocalDateTime datum_dostaven_odgovor;
    private LocalDateTime datum_promena;
    @Enumerated(EnumType.STRING)
    private DocumentStatus status_dokument;
    private String odgovor_file;
    private String komentar;
    private String promena;
    private int id_vraboten;
    private String ime_vraboten;
    private String prezime_vraboten;
    private String id_oddel;
    private String ime_oddel;

    public int getId_rekord() {
        return id_rekord;
    }

    public int getId_klient() {
        return id_klient;
    }

    public String getIme() {
        return ime;
    }

    public String getKompanija() {
        return kompanija;
    }

    public int getId_dokument() {
        return id_dokument;
    }

    public String getPredmet_na_dokument() {
        return predmet_na_dokument;
    }

    public LocalDateTime getDatum_primen() {
        return datum_primen;
    }

    public String getDostaven_file_od_klient() {
        return dostaven_file_od_klient;
    }

    public LocalDateTime getDatum_dostaven_odgovor() {
        return datum_dostaven_odgovor;
    }

    public LocalDateTime getDatum_promena() {
        return datum_promena;
    }

    public DocumentStatus getStatus_dokument() {
        return status_dokument;
    }

    public String getOdgovor_file() {
        return odgovor_file;
    }

    public String getKomentar() {
        return komentar;
    }

    public String getPromena() {
        return promena;
    }

    public int getId_vraboten() {
        return id_vraboten;
    }

    public String getIme_vraboten() {
        return ime_vraboten;
    }

    public String getPrezime_vraboten() {
        return prezime_vraboten;
    }

    public String getId_oddel() {
        return id_oddel;
    }

    public String getIme_oddel() {
        return ime_oddel;
    }
}
