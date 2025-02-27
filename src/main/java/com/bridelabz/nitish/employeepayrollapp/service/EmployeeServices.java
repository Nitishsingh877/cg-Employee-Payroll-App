package com.bridelabz.nitish.employeepayrollapp.service;

import com.bridelabz.nitish.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridelabz.nitish.employeepayrollapp.entities.EmployeePayrollData;


import java.util.List;
import java.util.Optional;

public interface EmployeeServices {
    List<EmployeePayrollData> getEmployeePayrollDataList();

    //sql
    List<EmployeePayrollData> getEmployessByDepartment(String department);
    Optional<EmployeePayrollData> getEmployee(int id);
    EmployeePayrollData addEmployee(EmployeePayrollDTO employeePayrollDTO);
    void   deleteEmployee(int id);
    EmployeePayrollData updateEmployeeSalary(int id, EmployeePayrollDTO employeePayrollDTO);

}
