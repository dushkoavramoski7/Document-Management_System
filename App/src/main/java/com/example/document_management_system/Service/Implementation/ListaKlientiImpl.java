package com.example.document_management_system.Service.Implementation;

import com.example.document_management_system.Model.Views.ListaKlienti;
import com.example.document_management_system.Repository.jpa.ListaKlientiRepository;
import com.example.document_management_system.Service.ListaKlientiService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListaKlientiImpl implements ListaKlientiService {
    private final ListaKlientiRepository listaKlientiRepository;

    public ListaKlientiImpl(ListaKlientiRepository listaKlientiRepository) {
        this.listaKlientiRepository = listaKlientiRepository;
    }

    @Override
    public List<ListaKlienti> findAll() {
        return listaKlientiRepository.findAll();
    }
}
