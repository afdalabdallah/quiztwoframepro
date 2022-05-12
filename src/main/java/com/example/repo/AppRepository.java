package com.example.repo;

import java.util.*;
import com.example.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface AppRepository extends JpaRepository<Appointment, Integer> {
    List<Appointment> findByName(String name);
}
