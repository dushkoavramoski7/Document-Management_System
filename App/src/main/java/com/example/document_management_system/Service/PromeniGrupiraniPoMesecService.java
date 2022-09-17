package com.example.document_management_system.Service;

import com.example.document_management_system.Model.Views.PromeniGrupiraniPoMesecGodina;

import java.math.BigInteger;
import java.util.List;

public interface PromeniGrupiraniPoMesecService {

    public List<PromeniGrupiraniPoMesecGodina> findAll();

    public List<PromeniGrupiraniPoMesecGodina> findAllByClient(Integer id_klient);

    public List<PromeniGrupiraniPoMesecGodina> filterByMonthYear(Integer client);
}
