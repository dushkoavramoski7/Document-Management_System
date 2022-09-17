package com.example.document_management_system.Service.Implementation;

import com.example.document_management_system.Model.Views.VrabotenKolkuRnsPromenil;
import com.example.document_management_system.Repository.jpa.VrabotenKolkuRnsPromenilRepository;
import com.example.document_management_system.Service.VrabotenKolkuRnsPromenilService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VrabotenKolkuRnsPromenilImpl implements VrabotenKolkuRnsPromenilService {
    private final VrabotenKolkuRnsPromenilRepository vrabotenKolkuRnsPromenilRepository;

    public VrabotenKolkuRnsPromenilImpl(VrabotenKolkuRnsPromenilRepository vrabotenKolkuRnsPromenilRepository) {
        this.vrabotenKolkuRnsPromenilRepository = vrabotenKolkuRnsPromenilRepository;
    }

    @Override
    public List<VrabotenKolkuRnsPromenil> findAllByIdVraboten(Integer employee) {
        return vrabotenKolkuRnsPromenilRepository.findAllByIdVraboten(employee);
    }
}
