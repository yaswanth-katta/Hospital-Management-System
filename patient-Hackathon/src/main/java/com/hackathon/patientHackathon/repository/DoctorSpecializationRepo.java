package com.hackathon.patientHackathon.repository;

import com.hackathon.patientHackathon.models.DoctorSpecialization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
public interface DoctorSpecializationRepo extends JpaRepository<DoctorSpecialization,Long> {
//    List<DoctorSpecialization> findByDiseasesContaining(String diseases);
}
