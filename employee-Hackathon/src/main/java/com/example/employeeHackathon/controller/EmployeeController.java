package com.example.employeeHackathon.controller;

import com.example.employeeHackathon.models.EmployeeProfile;
import com.example.employeeHackathon.models.LoginDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.employeeHackathon.service.EmployeeService;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping(value ="/registerEmployee")
    public EmployeeProfile registerEmployee(@RequestBody EmployeeProfile employeeProfile){
        return employeeService.registerEmployee(employeeProfile);
    }
    @GetMapping(value = "/getEmployeeById")
    public EmployeeProfile getEmployeeById(@PathVariable long employeeId){
        return employeeService.getEmployeeById(employeeId);
    }

    @GetMapping(value = "/getEmployeeLoginDetails/{userName}")
    public LoginDetails getEmployeeLoginDetails(@PathVariable String userName){
        return employeeService.getEmployeeLoginDetails(userName);
    }
}
