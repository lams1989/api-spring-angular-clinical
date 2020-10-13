package com.lams.clinical.clinicalapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lams.clinical.clinicalapp.entities.Patient;

@Repository
public interface ClinicalRepository extends JpaRepository<Patient, Integer>{

	Optional<Patient> findByDocNumberAndDocType(String docNumber, String docType);

	Optional<Patient> findByDocNumber(String docNumber);

}
