package com.hackathon.patientHackathon.models;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class DoctorCalendar {
    private long appointmentId;
    private String doctorName;
    private long doctorId;
    private String doctorEmail;
    private String appointmentTimeAndDate;
    private String patientName;
    private String specialization;
    private String patientEmail;
    private String disease;

}
