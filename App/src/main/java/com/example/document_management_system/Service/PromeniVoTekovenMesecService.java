package com.example.document_management_system.Service;

import com.example.document_management_system.Model.Views.PromeniVoTekovenMesec;

import java.util.List;

public interface PromeniVoTekovenMesecService {

    public List<PromeniVoTekovenMesec> findAllByClient(Integer id_klient);

    public List<PromeniVoTekovenMesec> filterTekovniPromeniByClient(Integer client);
}
