package com.project.hospital;

import com.project.hospital.model.Doctor;
import com.project.hospital.model.Patient;
import com.project.hospital.repository.DoctorRepository;
import com.project.hospital.repository.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class HospitalConfig {

    @Bean
    CommandLineRunner commandLineeRunner(DoctorRepository repository) {
        return args -> {
            Doctor jonas = new Doctor(
                    "Jonas",
                    "Jonaitis",
                    "864738493",
                    "Kaunas",
                    "Kauno klinikos",
                    "jonas.jonaitis@gmail.com"
            );

            Doctor petras = new Doctor(
                    "Petras",
                    "Petraitis",
                    "864238493",
                    "Vilnius",
                    "Santariškių ligoninė",
                    "petras.petraitis@gmail.com"
            );

            Doctor lukas = new Doctor(
                    "Lukas",
                    "Lukauskas",
                    "864231493",
                    "Vilnius",
                    "Karoliniškių poliklinika",
                    "lukas.lukauskas@gmail.com"
            );

            Doctor mantas = new Doctor(
                    "Mantas",
                    "Mantaitis",
                    "864238693",
                    "Tauragė",
                    "Tauragės viešoji ligoninė",
                    "mantas.mantaitis@gmail.com"
            );

            repository.saveAll(
                    List.of(mantas, petras, lukas, jonas)
            );

        };
    }

    @Bean
    CommandLineRunner commandLineRunner(PatientRepository repository) {
        return args -> {
            Patient matas = new Patient(
                    "Matas",
                    "Matauskas",
                    "1234567",
                    "Vilnius",
                    LocalDate.of(2000, 1, 5),
                    "matas.matauskas@gmail.com"
            );

            matas.setDoctor("Mantas Mantaitis");

            repository.saveAll(
                    List.of(matas)
            );

        };
    }
}
