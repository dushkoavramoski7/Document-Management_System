package com.example.document_management_system.Model;

import lombok.Data;
import javax.persistence.*;

@Entity  //klasa koja se povrzuva so baza na podatoci
@Data
@Table(name = "vraboten")
public class vraboten {
    @Id
    private int id_vraboten;
    @ManyToOne
    @JoinColumn(name="id_oddel", nullable = false)
    private oddel id_oddel;
    private String ime_vraboten;
    private String prezime_vraboten;


    public int getId_vraboten() {
        return id_vraboten;
    }

    public oddel getId_oddel() {
        return id_oddel;
    }

    public String getIme_vraboten() {
        return ime_vraboten;
    }

    public String getPrezime_vraboten() {
        return prezime_vraboten;
    }
}
