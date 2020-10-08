package com.lams.clinical.clinicalapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lams.clinical.clinicalapp.entities.Patient;

@Repository
public interface ClinicalRepository extends JpaRepository<Patient, Integer>{



}
