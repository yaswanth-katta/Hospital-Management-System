package com.hackathon.patientHackathon.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity @Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Ward{

    private int roomNumber;
    @Id
    private long patientId;
    private int cartNumber;
//    private long concernDoctor; //doctor Id  (optional)
//    @ManyToOne
//    private CareTaker careTaker; //map with care taker emp id
    private long careTaker;
    private String patientJoinDate;
    private String expectedDischargeDate;
//    private boolean isPatientInICU;  //optional
}
