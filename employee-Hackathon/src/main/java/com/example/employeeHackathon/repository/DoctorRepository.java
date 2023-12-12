package com.example.employeeHackathon.repository;

import com.example.employeeHackathon.models.DoctorProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<DoctorProfile,Long> {
}
