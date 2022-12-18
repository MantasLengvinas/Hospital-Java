package com.project.hospital.model;

import org.springframework.security.core.GrantedAuthority;

public enum AppUserRole implements GrantedAuthority {
    ROLE_ADMIN, ROLE_PATIENT, ROLE_DOCTOR;

    public String getAuthority() {
        return name();
    }

}