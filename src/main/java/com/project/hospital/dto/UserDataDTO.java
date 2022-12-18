package com.project.hospital.dto;

import java.util.List;

import com.project.hospital.model.AppUserRole;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDataDTO {

    private String username;
    private String email;
    private String password;
    List<AppUserRole> appUserRoles;

}