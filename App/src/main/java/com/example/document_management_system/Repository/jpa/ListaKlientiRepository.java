package com.example.document_management_system.Repository.jpa;

import com.example.document_management_system.Model.Views.ListaKlienti;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListaKlientiRepository extends JpaRepository<ListaKlienti, Integer> {

    //vrati lista od site klienti
    @Override
    List<ListaKlienti> findAll();

}
