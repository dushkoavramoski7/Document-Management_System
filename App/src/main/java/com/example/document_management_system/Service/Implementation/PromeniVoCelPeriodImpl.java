package com.example.document_management_system.Service.Implementation;

import com.example.document_management_system.Model.Views.PromeniVoCeliotPeriod;
import com.example.document_management_system.Repository.jpa.PromeniVoCelPeriodRepository;
import com.example.document_management_system.Service.PromeniVoCelPeriodService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromeniVoCelPeriodImpl implements PromeniVoCelPeriodService {
    private final PromeniVoCelPeriodRepository promeniVoCelPeriodRepository;

    public PromeniVoCelPeriodImpl(PromeniVoCelPeriodRepository promeniVoCelPeriodRepository) {
        this.promeniVoCelPeriodRepository = promeniVoCelPeriodRepository;
    }


    @Override
    public List<PromeniVoCeliotPeriod> findAllByClient(Integer id_klient) {
        return promeniVoCelPeriodRepository.findAllByClient(id_klient);
    }

    @Override
    public List<PromeniVoCeliotPeriod> filterCelPeriodPromeniByClient(String client) {

        if (client == null || Integer.parseInt(client)==0)
        {
            return promeniVoCelPeriodRepository.findAll();
        }
        return findAllByClient(Integer.parseInt(client));
    }
}
