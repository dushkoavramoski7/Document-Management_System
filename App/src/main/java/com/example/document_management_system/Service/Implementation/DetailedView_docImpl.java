package com.example.document_management_system.Service.Implementation;


import com.example.document_management_system.Model.Views.detailedView_doc;
import com.example.document_management_system.Repository.jpa.DetailedView_docRepository;
import com.example.document_management_system.Service.detailedView_docService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailedView_docImpl implements detailedView_docService {

    private final DetailedView_docRepository detailedView_docRepository;

    public DetailedView_docImpl(DetailedView_docRepository detailedView_docRepository) {
        this.detailedView_docRepository = detailedView_docRepository;
    }

    @Override
    public List<detailedView_doc> findAllbyDocument_Id(Integer id_dokument) {
        return detailedView_docRepository.findAllbyDocument_Id(id_dokument);
    }
}
