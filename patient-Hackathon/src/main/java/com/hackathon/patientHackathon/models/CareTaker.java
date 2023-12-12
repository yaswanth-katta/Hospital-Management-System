package com.hackathon.patientHackathon.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @AllArgsConstructor @NoArgsConstructor @Getter @Setter
@Table(name = "Care_Taker")
public class CareTaker {
    @Id
    private long careTakerId;
    private String password;
//    @OneToMany
//    private List<PatientProfile> assignedPatients; //may or may not be null
    private String careTakerName;
    private long contactNumber;
    private String address;
    private long experience; //In years
//    private String qualification;  //optional
    private String workingShifts;  // day shift or night shift


}
