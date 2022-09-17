package com.example.document_management_system.Repository.jpa;

import com.example.document_management_system.Model.Views.PromeniGrupiraniPoMesecGodina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface PromeniGrupiraniPoMesecRepository extends JpaRepository<PromeniGrupiraniPoMesecGodina,Integer> {


    @Override
    List<PromeniGrupiraniPoMesecGodina> findAll();

    // najdi po klient
    @Query("SELECT a from PromeniGrupiraniPoMesecGodina as a where a.idKlient = :id_klient")
    List<PromeniGrupiraniPoMesecGodina> findAllByClient (@Param("id_klient") Integer id_klient);


    // najdi po mesec i godina
    @Query("select a from PromeniGrupiraniPoMesecGodina  as a where a.idKlient = :id_klient and " +
            "a.mesec = :mesec and a.godina = :godina")
    List<PromeniGrupiraniPoMesecGodina> findAllByClientAndMonthYear(@Param("id_klient") Integer id_klient,
                                                                    @Param("mesec") BigInteger mesec,
                                                                    @Param("godina") BigInteger godina);

}
