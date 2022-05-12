package com.example.model;

import javax.persistence.*;
@Entity
@Table(name = "doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = true, length = 255)
    private String name;

    @Column(nullable = true, length = 255)
    private String specialization_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization_id() {
        return specialization_id;
    }

    public void setSpecialization_id(String specialization_id) {
        this.specialization_id = specialization_id;
    }
}
