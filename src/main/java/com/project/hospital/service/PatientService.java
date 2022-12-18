package com.project.hospital.service;

import com.project.hospital.model.Doctor;
import com.project.hospital.model.Patient;
import com.project.hospital.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;

@Service
public class PatientService {

    private final PatientRepository patientRepository;
    private final DoctorService doctorService;

    @Autowired
    public PatientService(PatientRepository patientRepository,DoctorService doctorService) {
        this.patientRepository = patientRepository;
        this.doctorService = doctorService;
    }

    public List<Patient> getPatients() {
        return patientRepository.findAll();
    }

    public Patient getPatient(Long id){
        Optional<Patient> patient = patientRepository.findPatientById(id);
        return patient.get();
    }

    public void addNewPatient(Patient patient) {
        Optional<Patient> patientByEmail = patientRepository.
                findPatientByEmail(patient.getEmail());

        if (patientByEmail.isPresent()) {
            throw new IllegalStateException("email taken");
        }

        List<Doctor> doctors = doctorService.getDoctors();
        Random rand = new Random();
        int i = rand.nextInt(doctors.size());
        patient.setDoctor(doctors.get(i).getName() + " " + doctors.get(i).getSurname());
        patientRepository.save(patient);
    }

    public void deletePatient(Long patientId) {
        boolean exists = patientRepository.existsById(patientId);
        if (!exists) {
            throw new IllegalStateException(
                    "patient with id" + patientId + "does not exist"
            );
        }

        patientRepository.deleteById(patientId);
    }

    @Transactional
    public void updatePatient(Long patientId, String name, String surname, String phone, String address, String email) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new IllegalStateException(
                        "patient with id " + patientId + " does not exist"
                ));

        if (address != null && address.length() > 0 &&  !Objects.equals(patient.getAddress(), address)) {
            patient.setAddress(address);
        }

        if (phone != null && phone.length() > 0 && !Objects.equals(patient.getEmail(), phone)) {
            patient.setPhone(phone);
        }

        if (name != null && name.length() > 0 &&  !Objects.equals(patient.getName(), name)) {
            patient.setName(name);
        }

        if (surname != null && surname.length() > 0 &&  !Objects.equals(patient.getSurname(), surname)) {
            patient.setSurname(surname);
        }

        if (email != null && email.length() > 0 &&  !Objects.equals(patient.getEmail(), email)) {
            patient.setEmail(email);
        }
    }
}
