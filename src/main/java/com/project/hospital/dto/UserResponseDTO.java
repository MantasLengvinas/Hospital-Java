package com.project.hospital.dto;

import java.util.List;

import com.project.hospital.model.AppUserRole;
import lombok.Data;

@Data
public class UserResponseDTO {

    private Integer id;
    private String username;
    private String email;
    List<AppUserRole> appUserRoles;

}