package com.hackathon.patientHackathon.controller;

import com.hackathon.patientHackathon.models.BookAppointment;
import com.hackathon.patientHackathon.models.PatientProfile;
import com.hackathon.patientHackathon.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class PatientController {
//    @GetMapping(value = "/getAllPatients")
//    public List<Pat>
    @Autowired
    private PatientService patientService;

    @PostMapping(value = "/registerPatient")
    public PatientProfile registerPatient(@RequestBody PatientProfile patientProfile){
        return patientService.registerPatient(patientProfile);
    }

    @GetMapping(value = "/getAllPatients")
    public List<PatientProfile> getAllPatients(){
        return patientService.getAllPatients();
    }

    @PostMapping(value = "/bookAppointment")
    public BookAppointment makeAppointment(@RequestBody BookAppointment bookAppointment){
        return patientService.makeAppointment(bookAppointment);
    }

    @GetMapping(value = "/getPatientById/{patientId}")
    public PatientProfile getPatientById(@PathVariable long patientId){
        return patientService.getPatientById(patientId);
    }

    @GetMapping(value = "/searchPatient/{patientId}/{fullName}/{email}/{status}")
    public List<PatientProfile> searchPatient(
            @PathVariable long patientId,@PathVariable String fullName,
            @PathVariable String email, @PathVariable String status
    ){
        return patientService.searchPatient(patientId,fullName,email,status);
    }



}
