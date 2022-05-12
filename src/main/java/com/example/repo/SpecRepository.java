package com.example.repo;

import java.util.*;

import com.example.model.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
public interface SpecRepository extends JpaRepository<Specialization, Integer> {
    List<Specialization> findByName(String name);
}
