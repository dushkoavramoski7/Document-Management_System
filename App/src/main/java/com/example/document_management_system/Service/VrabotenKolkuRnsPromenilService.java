package com.example.document_management_system.Service;

import com.example.document_management_system.Model.Views.VrabotenKolkuRnsPromenil;

import java.util.List;

public interface VrabotenKolkuRnsPromenilService {

    public List<VrabotenKolkuRnsPromenil> findAllByIdVraboten(Integer employee);
}
