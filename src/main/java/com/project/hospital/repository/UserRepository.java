package com.project.hospital.repository;

import javax.transaction.Transactional;

import com.project.hospital.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<AppUser, Integer> {

    boolean existsByUsername(String username);

    AppUser findByUsername(String username);

    @Transactional
    void deleteByUsername(String username);

}