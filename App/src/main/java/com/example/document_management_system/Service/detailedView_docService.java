package com.example.document_management_system.Service;

import com.example.document_management_system.Model.Views.detailedView_doc;

import java.util.List;

public interface detailedView_docService {

    List<detailedView_doc> findAllbyDocument_Id(Integer id_dokument);
}
