package com.example.document_management_system.Service;


import com.example.document_management_system.Model.Enum.DocumentStatus;
import com.example.document_management_system.Model.rekord_na_sledenje;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.Optional;

public interface RekordNaSledenjeService {

    public rekord_na_sledenje findById(Integer id_rekord);

    public Optional<rekord_na_sledenje> save(Integer id_dokument,
                                             Integer id_klient,
                                             Integer id_vraboten,
                                             LocalDateTime datum_dostavuvanje,
                                             LocalDateTime datum_promena,
                                             DocumentStatus status_dokument,
                                             String odgovor_file,
                                             String komentar,
                                             String promena,
                                             MultipartFile file,
                                             String tip_na_dokument) throws  Exception;

}
