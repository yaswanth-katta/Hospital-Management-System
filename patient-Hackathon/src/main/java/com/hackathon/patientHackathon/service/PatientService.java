package com.hackathon.patientHackathon.service;

import com.hackathon.patientHackathon.feign.AuthFeignClient;
import com.hackathon.patientHackathon.feign.DoctorFeignClient;
import com.hackathon.patientHackathon.models.*;
import com.hackathon.patientHackathon.repository.AppointmentRepo;
import com.hackathon.patientHackathon.repository.DoctorSpecializationRepo;
import com.hackathon.patientHackathon.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private AppointmentRepo appointmentRepo;
    @Autowired
    private AuthFeignClient authFeignClient;
    @Autowired
    private DoctorSpecializationRepo doctorSpecializationRepo;

    @Autowired
    private DoctorFeignClient doctorFeignClient;
    public PatientProfile registerPatient(PatientProfile patientProfile){
        LoginDetails loginDetails=new LoginDetails();
        loginDetails.setUserName(String.valueOf(patientProfile.getPatientId()));
        loginDetails.setPassword(patientProfile.getPassword());
        loginDetails.setRole("Patient");

        authFeignClient.addLoginDetails(loginDetails);
        return patientRepository.save(patientProfile);
    }
    public PatientProfile getPatientById(long patientId){
        return patientRepository.findById(patientId).orElseThrow();
    }
    public List<PatientProfile> getAllPatients(){
        return patientRepository.findAll();
    }

    public BookAppointment makeAppointment(BookAppointment bookAppointment){
        DoctorCalendar doctorCalendar=new DoctorCalendar();
        List<DoctorSpecialization> doctorSpecialization= doctorSpecializationRepo.findAll();

         BookAppointment bookAppointment1=appointmentRepo.save(bookAppointment);

//         for(String doctor:doctorSpecialization.get(doctorSpecialization.size()-1).getDiseases()){
//
//         }

        doctorCalendar.setAppointmentId(bookAppointment1.getAppointmentId());
        doctorCalendar.setPatientName(bookAppointment1.getPatientName());
        doctorCalendar.setAppointmentTimeAndDate(bookAppointment1.getAppointmentTiming());
        doctorCalendar.setPatientEmail(bookAppointment1.getEmail());
        doctorCalendar.setDisease(bookAppointment1.getDisease());
//        doctorCalendar.setDoctorId(doctorSpecialization.getDoctorId());
//        doctorCalendar.setDoctorEmail(doctorSpecialization.getDoctorEmail());
//        doctorCalendar.setDoctorName(doctorSpecialization.getDoctorName());

        System.out.println("Doctor ID :  ==  " +doctorSpecialization.get(0).getDoctorId());
        System.out.println("Doctor Name :  ==  " +doctorSpecialization.get(0).getDoctorName());
        System.out.println("Doctor list :  ==  " +doctorSpecialization.get(0).getDiseases().get(0));

        doctorFeignClient.addDoctorAppointments(doctorCalendar);
        return bookAppointment1;
    }

    public List<PatientProfile> searchPatient(long patientId,String fullName,String email,String status){
        return patientRepository.findByPatientIdOrFullNameOrEmailOrStatus(patientId,fullName,email,status);
    }



}
