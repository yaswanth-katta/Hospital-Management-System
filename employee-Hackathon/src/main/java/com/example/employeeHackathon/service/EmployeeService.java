package com.example.employeeHackathon.service;

import com.example.employeeHackathon.models.EmployeeProfile;
import com.example.employeeHackathon.models.LoginDetails;
import com.example.employeeHackathon.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    public EmployeeProfile registerEmployee(EmployeeProfile employeeProfile){
       return employeeRepository.save(employeeProfile);

    }
    public EmployeeProfile getEmployeeById(long employeeId){
        return employeeRepository.findById(employeeId).get();
    }

    public LoginDetails getEmployeeLoginDetails(String userName){
        EmployeeProfile employeeProfile=employeeRepository.findById(Long.valueOf(userName)).get();
        return new LoginDetails(String.valueOf(employeeProfile.getEmployeeId()),employeeProfile.getPassword());
    }
}

