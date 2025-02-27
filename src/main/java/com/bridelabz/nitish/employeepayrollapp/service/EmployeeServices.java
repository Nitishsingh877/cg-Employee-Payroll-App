package com.bridelabz.nitish.employeepayrollapp.service;

import com.bridelabz.nitish.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridelabz.nitish.employeepayrollapp.entities.EmployeePayrollData;


import java.util.List;

public interface EmployeeServices {
    List<EmployeePayrollData> getEmployees();
    EmployeePayrollDTO getEmployee(Long id);
    EmployeePayrollDTO addEmployee(String name, double salary);
    void deleteEmployee(Long id);
    EmployeePayrollDTO updateEmployeeSalary(Long id, double salary);
}
