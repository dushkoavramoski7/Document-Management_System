package com.example.document_management_system.Repository.jpa;


import com.example.document_management_system.Model.Enum.DocumentStatus;
import com.example.document_management_system.Model.Views.Lista_doc_odKlient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface List_doc_odKlientRepository extends JpaRepository<Lista_doc_odKlient, Integer> {

    //za daden vraboten koi dokumeni mu bile isprateni
    @Query("select a from Lista_doc_odKlient as a where a.id_vraboten = :id_vraboten")
    List<Lista_doc_odKlient> findAllbyEmployee(@Param("id_vraboten") Integer id_vraboten);

    //za daden vraboten koi klienti mu bile klienti
    @Query("select distinct(a.id_klient), a.ime  from Lista_doc_odKlient as a where a.id_vraboten = :id_vraboten")
    List<String> findAllclientsbyEmployee(@Param("id_vraboten") Integer id_vraboten);

    // prikaz samo za vrabotenite
    @Query("select a from Lista_doc_odKlient as a order by a.ime")
    List<Lista_doc_odKlient> findAll();

    //zemi lista od dokumenti prateni od daden klient so id = id_klient
    @Query("select a from Lista_doc_odKlient as a where a.id_klient = :id_klient")
    List<Lista_doc_odKlient> getDocumentsFromClient(@Param("id_klient") Integer id_klient);


    @Query("select count(a.id_dokument) from Lista_doc_odKlient as a where" +
            " a.status_dokument = :status_dokument and a.id_klient = :id_klient")
    Integer countByStatus (@Param("status_dokument") DocumentStatus status_dokument,
                           @Param("id_klient") Integer id_klient );



}
