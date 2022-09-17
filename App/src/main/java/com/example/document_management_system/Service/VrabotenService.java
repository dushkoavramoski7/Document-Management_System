package com.example.document_management_system.Service;

import com.example.document_management_system.Model.vraboten;

import java.util.List;

public interface VrabotenService {

    public List<vraboten> findAll();

    public List<vraboten> findAllByOddel(String oddel);
}
