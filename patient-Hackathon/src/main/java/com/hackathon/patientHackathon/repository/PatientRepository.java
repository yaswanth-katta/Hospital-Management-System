package com.hackathon.patientHackathon.repository;

import com.hackathon.patientHackathon.models.PatientProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<PatientProfile,Long> {
    public List<PatientProfile> findByPatientIdOrFullNameOrEmailOrStatus(
            long patientId, String fullName, String email, String status
    );
}
