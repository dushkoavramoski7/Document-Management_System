package com.example.document_management_system.Service.Implementation;


import com.example.document_management_system.Model.Views.PromeniGrupiraniPoMesecGodina;
import com.example.document_management_system.Repository.jpa.PromeniGrupiraniPoMesecRepository;
import com.example.document_management_system.Service.PromeniGrupiraniPoMesecService;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class PromeniGrupiraniPoMesecImpl implements PromeniGrupiraniPoMesecService {
    private final PromeniGrupiraniPoMesecRepository promeniGrupiraniPoMesecRepository;

    public PromeniGrupiraniPoMesecImpl(PromeniGrupiraniPoMesecRepository promeniGrupiraniPoMesecRepository) {
        this.promeniGrupiraniPoMesecRepository = promeniGrupiraniPoMesecRepository;
    }

    @Override
    public List<PromeniGrupiraniPoMesecGodina> findAll() {
        return promeniGrupiraniPoMesecRepository.findAll();
    }

    @Override
    public List<PromeniGrupiraniPoMesecGodina> findAllByClient(Integer id_klient) {
        return promeniGrupiraniPoMesecRepository.findAllByClient(id_klient);
    }

    @Override
    public List<PromeniGrupiraniPoMesecGodina> filterByMonthYear(Integer client) {
         if (client == null || client==0)
        {
            return findAll();
        }
        else {
            return findAllByClient(client);
        }
    }
}
