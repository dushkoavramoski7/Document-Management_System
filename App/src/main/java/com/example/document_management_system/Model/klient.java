package com.example.document_management_system.Model;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity  //klasa koja se povrzuva so baza na podatoci
@Data
@Table(name = "klient")
public class klient {
    @Id
    private int id_klient;
    private String kompanija;
    private String ime;

}
