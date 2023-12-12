package com.hackathon.patientHackathon.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
 @Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Visits {
     @Id
    private long appointmentId;
    private String appointmentStartDate;
    private String appointmentEndDate;
    private int remainingVisits;
}
