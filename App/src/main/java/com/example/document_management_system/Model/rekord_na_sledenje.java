package com.example.document_management_system.Model;


import com.example.document_management_system.Model.Enum.DocumentStatus;
import lombok.Data;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity  //klasa koja se povrzuva so baza na podatoci
@Data
@Table(name = "rekord_na_sledenje")
public class rekord_na_sledenje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_rekord;
    @ManyToOne
    @JoinColumn(name="id_dokument", nullable = false)
    private dokument id_dokument;
    @ManyToOne
    @JoinColumn(name="id_klient", nullable = false)
    private klient id_klient;
    @ManyToOne
    @JoinColumn(name="id_vraboten", nullable = false)
    private vraboten id_vraboten;
    private LocalDateTime datum_dostavuvanje;
    private LocalDateTime datum_promena;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private DocumentStatus status_dokument;
    private String odgovor_file;
    private String komentar;
    private String promena;
    private byte[] content;
    private String tip_na_dokument;

    public rekord_na_sledenje(dokument id_dokument, klient id_klient, vraboten id_vraboten, LocalDateTime datum_dostavuvanje, LocalDateTime datum_promena, DocumentStatus status_dokument, String odgovor_file, String komentar, String promena, byte[] content, String tip_na_dokument) {
        this.id_dokument = id_dokument;
        this.id_klient = id_klient;
        this.id_vraboten = id_vraboten;
        this.datum_dostavuvanje = datum_dostavuvanje;
        this.datum_promena = datum_promena;
        this.status_dokument = status_dokument;
        this.odgovor_file = odgovor_file;
        this.komentar = komentar;
        this.promena = promena;
        this.content = content;
        this.tip_na_dokument = tip_na_dokument;
    }

    public rekord_na_sledenje() {

    }

    public dokument getId_dokument() {
        return id_dokument;
    }

    public klient getId_klient() {
        return id_klient;
    }

    public vraboten getId_vraboten() {
        return id_vraboten;
    }

    public LocalDateTime getDatum_dostavuvanje() {
        return datum_dostavuvanje;
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

    public int getId_rekord() {
        return id_rekord;
    }

    public byte[] getContent() {
        return content;
    }

    public String getTip_na_dokument() {
        return tip_na_dokument;
    }
}
