package com.project;

import java.util.ArrayList;
import java.util.Arrays;

import com.project.hospital.model.AppUser;
import com.project.hospital.model.AppUserRole;
import com.project.hospital.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@RequiredArgsConstructor
public class Hospital implements CommandLineRunner {

	final UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(Hospital.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Override
	public void run(String... params) throws Exception {
		AppUser admin = new AppUser();
		admin.setUsername("admin");
		admin.setPassword("admin");
		admin.setEmail("admin@email.com");
		admin.setAppUserRoles(new ArrayList<AppUserRole>(Arrays.asList(AppUserRole.ROLE_ADMIN)));

		userService.signup(admin);

		AppUser patient = new AppUser();
		patient.setUsername("Matas Matauskas");
		patient.setPassword("matas");
		patient.setEmail("matas.matauskas@email.com");
		patient.setAppUserRoles(new ArrayList<AppUserRole>(Arrays.asList(AppUserRole.ROLE_PATIENT)));

		userService.signup(patient);

		AppUser mantas = new AppUser();
		mantas.setUsername("Mantas Mantaitis");
		mantas.setPassword("mantas");
		mantas.setEmail("mantas@email.com");
		mantas.setAppUserRoles(new ArrayList<AppUserRole>(Arrays.asList(AppUserRole.ROLE_DOCTOR)));

		userService.signup(mantas);



	}

}
