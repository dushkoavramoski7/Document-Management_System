package com.example.document_management_system.Service.Implementation;


import com.example.document_management_system.Model.Enum.DocumentStatus;
import com.example.document_management_system.Model.dokument;
import com.example.document_management_system.Model.klient;
import com.example.document_management_system.Model.rekord_na_sledenje;
import com.example.document_management_system.Model.vraboten;
import com.example.document_management_system.Repository.jpa.DocumentRepository;
import com.example.document_management_system.Repository.jpa.KlientRepository;
import com.example.document_management_system.Repository.jpa.RekordNaSledenjeRepository;
import com.example.document_management_system.Repository.jpa.VrabotenRepository;
import com.example.document_management_system.Service.RekordNaSledenjeService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class RekordNaSledenjeImpl implements RekordNaSledenjeService {
    private final RekordNaSledenjeRepository rekordNaSledenjeRepository;
    private final DocumentRepository documentRepository;
    private final VrabotenRepository vrabotenRepository;
    private final KlientRepository klientRepository;

    public RekordNaSledenjeImpl(RekordNaSledenjeRepository rekordNaSledenjeRepository, DocumentRepository documentRepository, VrabotenRepository vrabotenRepository, KlientRepository klientRepository) {
        this.rekordNaSledenjeRepository = rekordNaSledenjeRepository;
        this.documentRepository = documentRepository;
        this.vrabotenRepository = vrabotenRepository;
        this.klientRepository = klientRepository;
    }


    @Override
    public rekord_na_sledenje findById(Integer id_rekord) {
        return this.rekordNaSledenjeRepository.findById(id_rekord).get();
    }

    @Override
    @Transactional
    public Optional<rekord_na_sledenje> save(Integer id_dokument, Integer id_klient, Integer id_vraboten,
                                             LocalDateTime datum_dostavuvanje, LocalDateTime datum_promena,
                                             DocumentStatus status_dokument, String odgovor_file, String komentar,
                                             String promena, MultipartFile file, String tip_na_dokument) throws Exception {
        dokument dokument_obj =  this.documentRepository.findById(id_dokument)
                .orElseThrow(() -> new NoSuchElementException());
        klient klient_obj  = this.klientRepository.findById(id_klient)
                .orElseThrow(() -> new NoSuchElementException());
        vraboten vraboten_obj = this.vrabotenRepository.findById(id_vraboten)
                .orElseThrow(() -> new NoSuchElementException());


        rekord_na_sledenje rns = new rekord_na_sledenje(dokument_obj, klient_obj, vraboten_obj, datum_dostavuvanje,
                datum_promena, status_dokument, odgovor_file, komentar,promena, file.getBytes(),tip_na_dokument);
        return  Optional.of(this.rekordNaSledenjeRepository.save(rns));
    }
}
