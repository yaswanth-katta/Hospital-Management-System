package com.hackathon.patientHackathon.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class BookAppointment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long appointmentId;
    private long patientId;  //auto filled in UI
    private String patientName;
    private long doctorId; //auto assigned in UI
    private String disease; //show dropdown in UI
    private String appointmentTiming; //dropdown based in doctor availability
    private String appointmentStatus;  //active or close
    private String email;
    @OneToOne
    private Visits remainingVisits;

}
