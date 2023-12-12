package com.hackathon.patientHackathon.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class PatientProfile {
    @Id
    private long patientId;
    private String password;
    private String fullName;
    private long contactNumber;
    private String address;
    private int age;
    private String gender;
//    private Date dateOfBirth;  //optional
    private String currentDisease;
    @OneToOne
    private Medication currentMedication;
    @OneToOne
    private Ward wardDetails;
    private String status;   //In patient or out patient
    private String email;
}
