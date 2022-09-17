package com.example.document_management_system.Repository.jpa;

import com.example.document_management_system.Model.Views.PromeniGrupiraniPoMesecGodina;
import com.example.document_management_system.Model.Views.PromeniVoTekovenMesec;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PromeniVoTekovenMesecRepository extends JpaRepository<PromeniVoTekovenMesec, Integer> {

    @Override
    List<PromeniVoTekovenMesec> findAll();

    // najdi po klient
    @Query("SELECT a from PromeniVoTekovenMesec as a where a.idKlient = :id_klient")
    List<PromeniVoTekovenMesec> findAllByClient (@Param("id_klient") Integer id_klient);


}
