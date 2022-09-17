package com.example.document_management_system.Repository.jpa;

import com.example.document_management_system.Model.dokument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository extends JpaRepository<dokument, Integer > {

}
