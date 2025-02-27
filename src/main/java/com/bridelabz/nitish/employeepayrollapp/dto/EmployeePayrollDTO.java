package com.bridelabz.nitish.employeepayrollapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Data
public @ToString class EmployeePayrollDTO {
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$",message = "Employee name is invalid")
    public String name;

    @NotNull
    @Min(value = 500,message = "min wage should be more than 500")
    public double salary;

    @Pattern(regexp = "male|female",message = "Gender should be male or female")
    public String gender;

    @JsonFormat(pattern = "dd MMM yyyy")
    @NotNull(message = "start date should be empty.")
    @PastOrPresent(message = "start date should be past or today!! Enter valid date!")
    public LocalDate startDate;

    @NotBlank(message = "note cannot be empty")
    public String note;

    @NotBlank(message = "Profile pic should be present")
    public String profilePic;

    @NotNull(message = "department name should not be empty!")
    public List<String> departments;



}