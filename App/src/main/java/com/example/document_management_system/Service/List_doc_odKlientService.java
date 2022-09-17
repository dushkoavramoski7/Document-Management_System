package com.example.document_management_system.Service;

import com.example.document_management_system.Model.Enum.DocumentStatus;
import com.example.document_management_system.Model.Views.Lista_doc_odKlient;

import java.util.HashMap;
import java.util.List;

public interface List_doc_odKlientService {

    public List<Lista_doc_odKlient> findAll();

    public List<Lista_doc_odKlient> getDocumentsFromClient(Integer id_klient);

    public  List<Lista_doc_odKlient> filterDocumentsByClinet(Integer client);

    public List<Lista_doc_odKlient> findAllbyEmployee(Integer employee);

    public List<String> findAllclientsbyEmployee (Integer employee);


    public  Integer countByStatus(Integer client, DocumentStatus documentStatus);
}
