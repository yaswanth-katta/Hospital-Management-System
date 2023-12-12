package com.hackathon.patientHackathon.feign;

import com.hackathon.patientHackathon.models.DoctorCalendar;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "Employee-Microservice", url = "localhost:5100/employee")
public interface DoctorFeignClient {
    @PostMapping(value = "/addDoctorAppointment")
    public DoctorCalendar addDoctorAppointments(@RequestBody DoctorCalendar doctorCalendar);
}
