package com.example.document_management_system.Model;
import lombok.Data;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity  //klasa koja se povrzuva so baza na podatoci
@Data
@Table(name = "dokument")
public class dokument {
    private static final String DATE_FORMATTER= "yyyy-MM-dd HH:mm:ss";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_dokument;
    @ManyToOne
    @JoinColumn(name="id_klient", nullable = false)
    private klient id_klient;
    @ManyToOne
    @JoinColumn(name="id_vraboten", nullable = false)
    private vraboten id_vraboten;
    private String dostaven_file;
    private String tip_na_dokument;
    private String predmet_na_dokument;
    private LocalDateTime datum_primen;
    private byte[] content;

    public dokument(klient id_klient, vraboten id_vraboten, String dostaven_file, String tip_na_dokument, String predmet_na_dokument, LocalDateTime datum_primen, byte[] content) {
        this.id_klient = id_klient;
        this.id_vraboten = id_vraboten;
        this.dostaven_file = dostaven_file;
        this.tip_na_dokument = tip_na_dokument;
        this.predmet_na_dokument = predmet_na_dokument;
        this.datum_primen = datum_primen;
        this.content = content;
    }

    public dokument() {

    }

    public int getId_dokument() {
        return id_dokument;
    }

    public klient getId_klient() {
        return id_klient;
    }

    public vraboten getId_vraboten() {
        return id_vraboten;
    }

    public String getDostaven_file() {
        return dostaven_file;
    }

    public String getTip_na_dokument() {
        return tip_na_dokument;
    }

    public String getPredmet_na_dokument() {
        return predmet_na_dokument;
    }

    public LocalDateTime getDatum_primen() {
        return datum_primen;
    }
}
