package com.example.document_management_system.Service.Implementation;


import com.example.document_management_system.Model.Views.PromeniVoTekovenMesec;
import com.example.document_management_system.Repository.jpa.PromeniVoTekovenMesecRepository;
import com.example.document_management_system.Service.PromeniVoTekovenMesecService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromeniVoTekovenMesecImpl implements PromeniVoTekovenMesecService {
    private final PromeniVoTekovenMesecRepository promeniVoTekovenMesecRepository;

    public PromeniVoTekovenMesecImpl(PromeniVoTekovenMesecRepository promeniVoTekovenMesecRepository) {
        this.promeniVoTekovenMesecRepository = promeniVoTekovenMesecRepository;
    }

    @Override
    public List<PromeniVoTekovenMesec> findAllByClient(Integer id_klient) {
        return promeniVoTekovenMesecRepository.findAllByClient(id_klient);
    }

    public List<PromeniVoTekovenMesec> filterTekovniPromeniByClient(Integer client){
        if (client == null || client==0)
        {
            return promeniVoTekovenMesecRepository.findAll();
        }
        else {
            return findAllByClient(client);
        }
    }

}
