package com.example.employeeHackathon.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @NoArgsConstructor @AllArgsConstructor
@Entity
public class DoctorProfile {
    @Id
    private long doctorId;
    private String password;
    private String fullName;
    private long contactNumber;
    private String address;
    private String workingTimings;
    private String specialization;
    private int experience;
    private int rating;
//    private String successRate;
}
