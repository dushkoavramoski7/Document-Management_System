package com.example.document_management_system.Repository.jpa;

import com.example.document_management_system.Model.rekord_na_sledenje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RekordNaSledenjeRepository extends JpaRepository<rekord_na_sledenje, Integer> {


}
