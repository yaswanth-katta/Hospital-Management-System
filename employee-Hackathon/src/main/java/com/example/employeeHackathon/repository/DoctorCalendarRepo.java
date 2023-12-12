package com.example.employeeHackathon.repository;

import com.example.employeeHackathon.models.DoctorCalendar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorCalendarRepo extends JpaRepository<DoctorCalendar,Integer> {
}
