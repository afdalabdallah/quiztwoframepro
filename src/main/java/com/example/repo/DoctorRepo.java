package com.example.repo;

import com.example.model.Appointment;
import com.example.model.Doctor;
import com.example.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepo extends JpaRepository<Doctor, Integer> {
    List<Doctor> findByName(String name);
}
