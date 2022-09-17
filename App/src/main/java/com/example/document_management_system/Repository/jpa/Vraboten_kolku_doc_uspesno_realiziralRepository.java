package com.example.document_management_system.Repository.jpa;


import com.example.document_management_system.Model.Views.Vraboten_kolku_doc_uspesno_realiziral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Vraboten_kolku_doc_uspesno_realiziralRepository extends JpaRepository<Vraboten_kolku_doc_uspesno_realiziral, Integer> {

    @Override
    List<Vraboten_kolku_doc_uspesno_realiziral> findAll();

    @Query("select a from Vraboten_kolku_doc_uspesno_realiziral as a where a.id_vraboten = :id_vraboten")
    List<Vraboten_kolku_doc_uspesno_realiziral> findAllById(@Param("id_vraboten") Integer id_vraboten);

}
