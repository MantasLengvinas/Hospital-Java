package com.project.hospital.controller;

import com.project.hospital.model.Patient;
import com.project.hospital.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path="/api/patient")
public class PatientsController {

    private final PatientService patientService;

    @Autowired
    public PatientsController(PatientService patientService) {
        this.patientService = patientService;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<Patient> getPatients() {
        return patientService.getPatients();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping(path = "{patientId}")
    public Patient getPatient(
            @PathVariable("patientId") Long patientId
    ) {
        return patientService.getPatient(patientId);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void registerNewPatient(
            @RequestParam String name,
            @RequestParam String surname,
            @RequestParam String phone,
            @RequestParam String address,
            @RequestParam String email
    ) {
        Patient patient = new Patient(name, surname, phone, address, LocalDate.parse("2022-12-05"), email);
        patientService.addNewPatient(patient);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping(path = "{patientId}")
    public void deletePatient(@PathVariable("patientId") Long patientId) {
        patientService.deletePatient(patientId);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping(path = "{patientId}")
    public void updatePatient(
            @PathVariable("patientId") Long patientId,
            @RequestParam String name,
            @RequestParam String surname,
            @RequestParam String phone,
            @RequestParam String address,
            @RequestParam String email
    ) {
        patientService.updatePatient(patientId, name, surname, phone, address, email);
    }
}
