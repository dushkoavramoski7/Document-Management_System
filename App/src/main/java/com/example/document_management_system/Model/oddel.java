package com.example.document_management_system.Model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity  //klasa koja se povrzuva so baza na podatoci
@Table(name = "oddel")
public class oddel {

    @Id
    private String  id_oddel;
    private String ime_oddel;

    public String getId_oddel() {
        return id_oddel;
    }

    public String getIme_oddel() {
        return ime_oddel;
    }
}
