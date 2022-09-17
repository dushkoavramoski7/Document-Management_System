package com.example.document_management_system.Model.Composite_Primary_Keys;

import java.io.Serializable;
import java.util.Objects;

public class DokumentId  implements Serializable {

    private int id_klient;
    private int id_dokument;

    //default
    public DokumentId() {
    }

    public DokumentId(int id_klient, int id_dokument) {
        this.id_klient = id_klient;
        this.id_dokument = id_dokument;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DokumentId that = (DokumentId) o;
        return id_klient == that.id_klient && id_dokument == that.id_dokument;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_klient, id_dokument);
    }
}
