package com.example.demo.dto;


import com.example.demo.Enum.AdmissionStatus;
import com.example.demo.Enum.Gender;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class StudentDto {
    @NotBlank(message = "Name is mandatory")
    @Size(max = 20, message = "Name must be at most 20 characters")
    private String name;

    @NotBlank(message = "Contact number is mandatory")
    @Pattern(regexp = "^\\d{10}$", message = "Contact number must be 10 digits")
    private String contactNumber;

    @NotBlank(message = "Address is mandatory")
    @Size(max = 255, message = "Address must be at most 255 characters")
    private String address;

    @NotNull(message = "Gender is mandatory")
    private Gender gender;

    @Min(value = 18, message = "Age must be at least 18")
    @Max(value = 40, message = "Age must be at most 40")
    private Long age;


    @NotBlank(message = "NID is mandatory")
    private String nid;

    @DecimalMin(value = "3.5", inclusive = true, message = "SSC result must be at least 3.5")
    private Double sscResult;

    @DecimalMin(value = "3.0", inclusive = true, message = "HSC result must be at least 3.0")
    private Double hscResult;

    @NotNull(message = "Admission status is mandatory")
    private AdmissionStatus admissionStatus;


    private LocalDate createdAt;

    private LocalDate updatedAt;

    public @NotBlank(message = "Name is mandatory") @Size(max = 20, message = "Name must be at most 20 characters") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "Name is mandatory") @Size(max = 20, message = "Name must be at most 20 characters") String name) {
        this.name = name;
    }

    public @NotBlank(message = "Contact number is mandatory") @Pattern(regexp = "^\\d{10}$", message = "Contact number must be 10 digits") String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(@NotBlank(message = "Contact number is mandatory") @Pattern(regexp = "^\\d{10}$", message = "Contact number must be 10 digits") String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public @NotBlank(message = "Address is mandatory") @Size(max = 255, message = "Address must be at most 255 characters") String getAddress() {
        return address;
    }

    public void setAddress(@NotBlank(message = "Address is mandatory") @Size(max = 255, message = "Address must be at most 255 characters") String address) {
        this.address = address;
    }

    public @NotNull(message = "Gender is mandatory") Gender getGender() {
        return gender;
    }

    public void setGender(@NotNull(message = "Gender is mandatory") Gender gender) {
        this.gender = gender;
    }

    public @Min(value = 18, message = "Age must be at least 18") @Max(value = 40, message = "Age must be at most 40") Long getAge() {
        return age;
    }

    public void setAge(@Min(value = 18, message = "Age must be at least 18") @Max(value = 40, message = "Age must be at most 40") Long age) {
        this.age = age;
    }

    public long getNid() {
        return Long.parseLong(nid);
    }

    public void setNid(@NotBlank(message = "NID is mandatory") String nid) {
        this.nid = nid;
    }

    public @DecimalMin(value = "3.5", inclusive = true, message = "SSC result must be at least 3.5") Double getSscResult() {
        return sscResult;
    }

    public void setSscResult(@DecimalMin(value = "3.5", inclusive = true, message = "SSC result must be at least 3.5") Double sscResult) {
        this.sscResult = sscResult;
    }

    public @DecimalMin(value = "3.0", inclusive = true, message = "HSC result must be at least 3.0") Double getHscResult() {
        return hscResult;
    }

    public void setHscResult(@DecimalMin(value = "3.0", inclusive = true, message = "HSC result must be at least 3.0") Double hscResult) {
        this.hscResult = hscResult;
    }

    public @NotNull(message = "Admission status is mandatory") AdmissionStatus getAdmissionStatus() {
        return admissionStatus;
    }

    public void setAdmissionStatus(@NotNull(message = "Admission status is mandatory") AdmissionStatus admissionStatus) {
        this.admissionStatus = admissionStatus;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }

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
