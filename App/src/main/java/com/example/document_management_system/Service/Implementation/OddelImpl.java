package com.example.document_management_system.Service.Implementation;

import com.example.document_management_system.Model.oddel;
import com.example.document_management_system.Repository.jpa.OddelRepository;
import com.example.document_management_system.Service.OddelService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OddelImpl implements OddelService {
    private  final OddelRepository oddelRepository;

    public OddelImpl(OddelRepository oddelRepository) {
        this.oddelRepository = oddelRepository;
    }

    @Override
    public List<oddel> findAll() {
        return oddelRepository.findAll();
    }


}
