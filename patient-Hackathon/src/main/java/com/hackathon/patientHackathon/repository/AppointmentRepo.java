package com.hackathon.patientHackathon.repository;

import com.hackathon.patientHackathon.models.BookAppointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepo extends JpaRepository<BookAppointment,Long> {
}
