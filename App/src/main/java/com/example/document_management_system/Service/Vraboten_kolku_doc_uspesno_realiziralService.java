package com.example.document_management_system.Service;

import com.example.document_management_system.Model.Views.Vraboten_kolku_doc_uspesno_realiziral;

import java.util.List;
import java.util.Optional;

public interface Vraboten_kolku_doc_uspesno_realiziralService {

    public List<Vraboten_kolku_doc_uspesno_realiziral> findbyId(Integer employee);


    public List<Vraboten_kolku_doc_uspesno_realiziral> findAll();

}
