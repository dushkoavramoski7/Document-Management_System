package com.example.document_management_system.Model.Composite_Primary_Keys;


import java.io.Serializable;
import java.math.BigInteger;
import java.util.Objects;

public class KlientMesecGodina  implements Serializable {

    private Integer idKlient;
    private BigInteger mesec;
    private BigInteger godina;

    public KlientMesecGodina() {
    }

    public KlientMesecGodina(Integer idKlient, BigInteger mesec, BigInteger godina) {
        this.idKlient = idKlient;
        this.mesec = mesec;
        this.godina = godina;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KlientMesecGodina that = (KlientMesecGodina) o;
        return idKlient.equals(that.idKlient) && mesec.equals(that.mesec) && godina.equals(that.godina);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idKlient, mesec, godina);
    }
}
