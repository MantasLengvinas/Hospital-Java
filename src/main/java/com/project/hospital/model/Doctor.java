package com.project.hospital.model;

import javax.persistence.*;

@Entity
@Table
public class Doctor {
    @Id
    @SequenceGenerator(
            name="doctor_sequence",
            sequenceName = "doctor_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "doctor_sequence"
    )
    private Long id;
    private String name;
    private  String surname;
    private String phone;
    private String address;
    private String institution;
    private String email;

    public Doctor(Long id, String name, String surname, String phone, String address, String institution, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.address = address;
        this.institution = institution;
        this.email = email;
    }

    public Doctor() {
    }

    public Doctor(String name, String surname, String phone, String address, String institution, String email) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.address = address;
        this.institution = institution;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", institution=" + institution + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
