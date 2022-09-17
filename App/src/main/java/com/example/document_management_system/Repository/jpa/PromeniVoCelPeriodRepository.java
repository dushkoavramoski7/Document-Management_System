package com.example.document_management_system.Repository.jpa;

import com.example.document_management_system.Model.Views.PromeniVoCeliotPeriod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PromeniVoCelPeriodRepository extends JpaRepository<PromeniVoCeliotPeriod, Integer> {

    // za employee
    @Override
    List<PromeniVoCeliotPeriod> findAll();

    // prikpaz na doc za razlicni klienti
    @Query("select a from PromeniVoCeliotPeriod as a where a.idKlient = :id_klient")
    List<PromeniVoCeliotPeriod> findAllByClient(@Param("id_klient") Integer id_klient);



}
