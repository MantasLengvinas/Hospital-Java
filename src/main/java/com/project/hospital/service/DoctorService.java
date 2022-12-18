package com.project.hospital.service;

import com.project.hospital.model.Doctor;
import com.project.hospital.model.Patient;
import com.project.hospital.repository.DoctorRepository;
import com.project.hospital.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<Doctor> getDoctors() {
        return doctorRepository.findAll();
    }

    public void addNewDoctor(Doctor doctor) {
        Optional<Doctor> doctorByEmail = doctorRepository.
                findDoctorByEmail(doctor.getEmail());

        if (doctorByEmail.isPresent()) {
            throw new IllegalStateException("email taken");
        }

        doctorRepository.save(doctor);
    }

    public void deleteDoctor(Long doctorId) {
        boolean exists = doctorRepository.existsById(doctorId);
        if (!exists) {
            throw new IllegalStateException(
                    "doctor with id" + doctorId + "does not exist"
            );
        }

        doctorRepository.deleteById(doctorId);
    }

    @Transactional
    public void updateDoctor(Long doctorId, String name, String surname, String phone, String address, String institution, String email) {
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new IllegalStateException(
                        "doctor with id " + doctorId + " does not exist"
                ));

        if (address != null && address.length() > 0 &&  !Objects.equals(doctor.getAddress(), address)) {
            doctor.setAddress(address);
        }

        if (phone != null && phone.length() > 0 && !Objects.equals(doctor.getEmail(), phone)) {
            doctor.setPhone(phone);
        }

        if (name != null && name.length() > 0 &&  !Objects.equals(doctor.getName(), name)) {
            doctor.setName(name);
        }

        if (surname != null && surname.length() > 0 &&  !Objects.equals(doctor.getSurname(), surname)) {
            doctor.setSurname(surname);
        }

        if (email != null && email.length() > 0 &&  !Objects.equals(doctor.getEmail(), email)) {
            doctor.setEmail(email);
        }

        if (institution != null && institution.length() > 0 &&  !Objects.equals(doctor.getInstitution(), institution)) {
            doctor.setInstitution(institution);
        }
    }
}
