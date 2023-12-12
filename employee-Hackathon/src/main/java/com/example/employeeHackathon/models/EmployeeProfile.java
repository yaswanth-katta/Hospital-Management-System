package com.example.employeeHackathon.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @NoArgsConstructor @AllArgsConstructor
@Entity
public class EmployeeProfile {  //Working staff (not doctor)
    @Id
    private long employeeId;
    private String fullName;
    private String address;
    private long contactNumber;
    private String emailId;
    private long emergencyContactNumber;
    private String password;
    private String confirmPassword;

}
