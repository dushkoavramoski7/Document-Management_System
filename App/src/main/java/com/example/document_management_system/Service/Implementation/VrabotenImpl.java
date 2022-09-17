package com.example.document_management_system.Service.Implementation;





import com.example.document_management_system.Model.oddel;
import com.example.document_management_system.Model.vraboten;
import com.example.document_management_system.Repository.jpa.OddelRepository;
import com.example.document_management_system.Repository.jpa.VrabotenRepository;
import com.example.document_management_system.Service.VrabotenService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VrabotenImpl implements VrabotenService {
    private final VrabotenRepository vrabotenRepository;
    private final OddelRepository oddelRepository;

    public VrabotenImpl(VrabotenRepository vrabotenRepository, OddelRepository oddelRepository) {
        this.vrabotenRepository = vrabotenRepository;
        this.oddelRepository = oddelRepository;
    }

    @Override
    public List<vraboten> findAll() {
        return vrabotenRepository.findAllVraboteni();
    }

    @Override
    public List<vraboten> findAllByOddel(String oddel123) {
          oddel oddel1 =this.oddelRepository.findById(oddel123).stream().findFirst().get();
        return this.vrabotenRepository.findAllById_oddel(oddel1);
    }
}
