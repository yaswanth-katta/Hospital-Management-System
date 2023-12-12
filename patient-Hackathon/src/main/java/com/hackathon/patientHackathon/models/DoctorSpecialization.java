package com.hackathon.patientHackathon.models;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DoctorSpecialization {
    @Id
    private long doctorId;
    private String specialization;
    private String doctorEmail;
    private String doctorName;
    private List<String> diseases;
}
