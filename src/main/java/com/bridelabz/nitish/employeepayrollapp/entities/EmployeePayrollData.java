package com.bridelabz.nitish.employeepayrollapp.entities;

import com.bridelabz.nitish.employeepayrollapp.dto.EmployeePayrollDTO;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

public @Data class EmployeePayrollData {
    private int employeeId;
    private String name;
    private double salary;
    private String gender;
    private LocalDate startDate;
    private String note;
    private String profilePic;
    private List<String> departments;

    public EmployeePayrollData() {}

    public EmployeePayrollData(int employeeId, EmployeePayrollDTO employee) {
        this.employeeId = employeeId;
        this.name = employee.name;
        this.salary = employee.salary;
        this.gender = employee.gender;
        this.note = employee.note;
        this.profilePic = employee.profilePic;
        this.departments = employee.departments;


    }

}
