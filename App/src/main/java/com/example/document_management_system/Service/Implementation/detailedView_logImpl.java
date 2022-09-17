package com.example.document_management_system.Service.Implementation;

import com.example.document_management_system.Model.Views.detailedView_log;
import com.example.document_management_system.Repository.jpa.detailedView_logRepository;
import com.example.document_management_system.Service.detailedView_logService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class detailedView_logImpl implements detailedView_logService {

    private final detailedView_logRepository detailedView_logRepository;

    public detailedView_logImpl(com.example.document_management_system.Repository.jpa.detailedView_logRepository detailedView_logRepository) {
        this.detailedView_logRepository = detailedView_logRepository;
    }

    @Override
    public detailedView_log findById_rekord(Integer id_rekord) {
        return detailedView_logRepository.findById_rekord(id_rekord);
    }
}
