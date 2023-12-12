package com.example.employeeHackathon.service;

import com.example.employeeHackathon.models.DoctorCalendar;
import com.example.employeeHackathon.models.DoctorProfile;
import com.example.employeeHackathon.models.LoginDetails;
import com.example.employeeHackathon.repository.DoctorCalendarRepo;
import com.example.employeeHackathon.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private DoctorCalendarRepo doctorCalendarRepo;
    public DoctorProfile registerDoctor(DoctorProfile doctorProfile){
        return doctorRepository.save(doctorProfile);
    }
    public DoctorProfile getDoctorById(long doctorId){
        return doctorRepository.findById(doctorId).get();
    }

    public List<DoctorProfile> getAllDoctors(){
        return doctorRepository.findAll();
    }

    public LoginDetails getLoginDetails(String userName){
        DoctorProfile doctorProfile=doctorRepository.findById(Long.valueOf(userName)).get();
        return new LoginDetails(String.valueOf(doctorProfile.getDoctorId()),doctorProfile.getPassword());
    }

    public DoctorCalendar addDoctorAppointment(DoctorCalendar doctorCalendar){
        return doctorCalendarRepo.save(doctorCalendar);
    }

    public List<DoctorCalendar> getDoctorAppointments(){
        return doctorCalendarRepo.findAll();
    }


}
