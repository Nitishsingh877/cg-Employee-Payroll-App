package com.bridelabz.nitish.employeepayrollapp.entities;

import com.bridelabz.nitish.employeepayrollapp.dto.EmployeePayrollDTO;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
@Entity
@Table(name = "Employee_Payroll")
public @Data class EmployeePayrollData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private int employeeId;

    @Column(name = "name")
    private String name;
    private double salary;
    private String gender;
    private LocalDate startDate;
    private String note;
    private String profilePic;

    @ElementCollection
    @CollectionTable(name = "employee_Department",joinColumns = @JoinColumn(name = "id"))
    private List<String> departments;

    public EmployeePayrollData() {}

    public EmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        this.updateEmployeePayrollData(employeePayrollDTO);
    }

    public void updateEmployeePayrollData( EmployeePayrollDTO employee) {
        this.name = employee.getName();
        this.salary = employee.salary;
        this.gender = employee.gender;
        this.startDate = employee.getStartDate();
        this.note = employee.note;
        this.profilePic = employee.profilePic;
        this.departments = employee.departments;


    }


}
