package com.hackathon.patientHackathon.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @AllArgsConstructor @NoArgsConstructor
public class LoginDetails {
    private String userName;
    private String password;
    private String role;
}
