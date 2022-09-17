package com.example.document_management_system.Repository.jpa;


import com.example.document_management_system.Model.Views.detailedView_doc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetailedView_docRepository extends JpaRepository<detailedView_doc, Integer> {

    //za praten dokument zemi negovi rekordi na sledenja
    @Query("select a from detailedView_doc as a where a.id_dokument = :id_document")
    List<detailedView_doc> findAllbyDocument_Id (@Param("id_document") Integer id_document);



}
