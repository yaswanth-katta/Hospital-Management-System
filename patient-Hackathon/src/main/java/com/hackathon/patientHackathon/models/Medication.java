package com.hackathon.patientHackathon.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Medication {
    @Id
    private long medicationId;
    private String medicationName; //if there are multiple then separate with commas
}
