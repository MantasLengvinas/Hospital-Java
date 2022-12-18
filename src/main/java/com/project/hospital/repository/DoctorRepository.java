package com.project.hospital.repository;

import com.project.hospital.model.Doctor;
import com.project.hospital.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    @Query("SELECT d FROM Doctor d WHERE d.email = ?1")
    Optional<Doctor> findDoctorByEmail(String email);
}