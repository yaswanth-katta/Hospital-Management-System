package com.example.employeeHackathon.controller;

import com.example.employeeHackathon.models.DoctorCalendar;
import com.example.employeeHackathon.models.DoctorProfile;
import com.example.employeeHackathon.models.LoginDetails;
import com.example.employeeHackathon.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;
    @PostMapping(value = "/registerDoctor")
    public DoctorProfile registerDoctor(@RequestBody DoctorProfile doctorProfile){
        return doctorService.registerDoctor(doctorProfile);
    }

    @GetMapping(value = "/getDoctorById")
    public DoctorProfile getDoctorById(@PathVariable long doctorId){
        return doctorService.getDoctorById(doctorId);
    }

    @GetMapping(value = "/getAllDoctors")
    public List<DoctorProfile> getAllDoctors(){
        return doctorService.getAllDoctors();
    }

    @GetMapping(value = "/getDoctorLoginDetails/{userName}")
    public LoginDetails getDoctorLoginDetails(@PathVariable String userName){
        return doctorService.getLoginDetails(userName);
    }

    @PostMapping(value = "/addDoctorAppointment")
    public DoctorCalendar addDoctorAppointments(@RequestBody DoctorCalendar doctorCalendar){
        return doctorService.addDoctorAppointment(doctorCalendar);
    }

    @GetMapping(value = "/getDoctorAppointments")
    public List<DoctorCalendar> getDoctorAppointments(){
        return doctorService.getDoctorAppointments();
    }


}
