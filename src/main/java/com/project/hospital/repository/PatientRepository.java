package com.project.hospital.repository;

import com.project.hospital.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Query("SELECT s FROM Patient s WHERE s.email = ?1")
    Optional<Patient> findPatientByEmail(String email);

    @Query("SELECT s FROM Patient s WHERE s.id = ?1")
    Optional<Patient> findPatientById(Long id);

}
