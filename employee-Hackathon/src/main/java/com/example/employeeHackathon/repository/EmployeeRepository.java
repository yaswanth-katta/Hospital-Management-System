package com.example.employeeHackathon.repository;

import com.example.employeeHackathon.models.EmployeeProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeProfile,Long> {

}
