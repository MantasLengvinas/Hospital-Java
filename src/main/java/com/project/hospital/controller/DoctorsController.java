package com.project.hospital.controller;

import com.project.hospital.model.Doctor;
import com.project.hospital.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path="/api/doctor")
public class DoctorsController {

    private final DoctorService doctorService;

    @Autowired
    public DoctorsController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<Doctor> getDoctors() {
        return doctorService.getDoctors();
    }



    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void registerNewDoctor(
            @RequestParam String name,
            @RequestParam String surname,
            @RequestParam String phone,
            @RequestParam String address,
            @RequestParam String institution,
            @RequestParam String email
    ) {
        Doctor doctor = new Doctor(name, surname, phone, address, institution, email);
        doctorService.addNewDoctor(doctor);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping(path = "{doctorId}")
    public void deleteDoctor(@PathVariable("doctorId") Long doctorId) {
        doctorService.deleteDoctor(doctorId);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping(path = "{doctorId}")
    public void updateDoctor(
            @PathVariable("doctorId") Long doctorId,
            @RequestParam String name,
            @RequestParam String surname,
            @RequestParam String phone,
            @RequestParam String address,
            @RequestParam String institution,
            @RequestParam String email
    ) {
        doctorService.updateDoctor(doctorId, name, surname, phone, address, institution, email);
    }
}