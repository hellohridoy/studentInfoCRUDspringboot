package com.example.demo.entity;


import com.example.demo.Enum.AdmissionStatus;
import com.example.demo.Enum.Gender;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
@Data
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String contactNumber;

    private String address;

    private Gender gender;

    private long age;

    private long nid;

    private double sscResult;

    private double hscResult;

    private AdmissionStatus admissionStatus;

    private LocalDate createdAt;

    private LocalDate updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDate.now();
        this.updatedAt = LocalDate.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDate.now();
    }

}
