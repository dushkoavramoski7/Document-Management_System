package com.example.document_management_system.Repository.jpa;

import com.example.document_management_system.Model.Views.detailedView_log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface detailedView_logRepository extends JpaRepository<detailedView_log, Integer> {

    // prikaz samo za vrabotenite
    @Override
    List<detailedView_log> findAll();

    //zemi select za daden id na rekord
    @Query("select a from detailedView_log as a where a.id_rekord = :id_rekord")
    detailedView_log findById_rekord(@Param("id_rekord") Integer id_rekord);

}
