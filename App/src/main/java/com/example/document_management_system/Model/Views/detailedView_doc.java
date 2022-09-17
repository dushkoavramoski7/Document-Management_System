package com.example.document_management_system.Model.Views;


import com.example.document_management_system.Model.Enum.DocumentStatus;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Immutable
@Table(name="detialview_document")
public class detailedView_doc {
    private static final String DATE_FORMATTER= "yyyy-MM-dd HH:mm:ss";

    private int id_dokument;
    private int id_klient;
    private String ime;
    private LocalDateTime datum_primen;
    private String predmet_na_dokument;
    private String tip_na_dokument;
    private String dostaven_file;
    @Id
    private int id_rekord;
    private LocalDateTime datum_promena;
    @Enumerated(EnumType.STRING)
    private DocumentStatus status_dokument;

    public String getIme() {
        return ime;
    }

    public int getId_dokument() {
        return id_dokument;
    }

    public int getId_klient() {
        return id_klient;
    }

    public String getDatum_primen() {
        return DateTimeFormatter.ofPattern(DATE_FORMATTER).format(datum_primen);
    }

    public DayOfWeek getDatum_primenDen()
    {
        return datum_primen.getDayOfWeek();
    }


    public String getPredmet_na_dokument() {
        return predmet_na_dokument;
    }

    public String getTip_na_dokument() {
        return tip_na_dokument;
    }

    public String getDostaven_file() {
        return dostaven_file;
    }

    public int getId_rekord() {
        return id_rekord;
    }

    public String getDatum_promena() {
        return  DateTimeFormatter.ofPattern(DATE_FORMATTER).format(datum_promena);
    }
    public DayOfWeek getDatum_promenaDen()
    {
        return datum_promena.getDayOfWeek();
    }
    public DocumentStatus getStatus_dokument() {
        return status_dokument;
    }


}
