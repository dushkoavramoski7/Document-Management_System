package com.example.document_management_system.Repository.jpa;


import com.example.document_management_system.Model.Views.VrabotenKolkuRnsPromenil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VrabotenKolkuRnsPromenilRepository extends JpaRepository<VrabotenKolkuRnsPromenil, Integer> {


    @Query("select a from VrabotenKolkuRnsPromenil as a where a.id_vraboten = :id_vraboten ")
    List<VrabotenKolkuRnsPromenil> findAllByIdVraboten(@Param("id_vraboten") Integer id_vraboten);
}
