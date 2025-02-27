package com.bridelabz.nitish.employeepayrollapp.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;


public @ToString class EmployeePayrollDTO {
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$",message = "Employee name is invalid")
    public String name;

    @NotNull
    @Min(value = 500,message = "min wage should be more than 500")
    public double salary;

    public String gender;
    public String startDate;
    public String note;
    public String profilePic;
    public List<String> departments;



}