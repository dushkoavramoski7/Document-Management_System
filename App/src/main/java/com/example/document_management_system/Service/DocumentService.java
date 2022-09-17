package com.example.document_management_system.Service;

import com.example.document_management_system.Model.dokument;
import com.example.document_management_system.Model.klient;
import com.example.document_management_system.Model.vraboten;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface DocumentService {


    public dokument save(Integer id_klient,
                         String id_oddel,
                         String dostaven_file,
                         String tip_na_dokument,
                         String predmet_na_dokument,
                         MultipartFile file) throws IOException;

    public dokument findByid(Integer id);


}
