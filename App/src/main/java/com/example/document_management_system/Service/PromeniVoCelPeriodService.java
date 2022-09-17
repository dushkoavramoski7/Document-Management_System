package com.example.document_management_system.Service;

import com.example.document_management_system.Model.Views.PromeniVoCeliotPeriod;
import com.example.document_management_system.Model.Views.PromeniVoTekovenMesec;

import java.util.List;

public interface PromeniVoCelPeriodService {

    public List<PromeniVoCeliotPeriod> findAllByClient(Integer id_klient);

    public List<PromeniVoCeliotPeriod> filterCelPeriodPromeniByClient(String client);





}
