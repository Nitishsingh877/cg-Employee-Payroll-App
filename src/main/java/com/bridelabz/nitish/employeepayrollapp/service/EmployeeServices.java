package com.bridelabz.nitish.employeepayrollapp.service;

import com.bridelabz.nitish.employeepayrollapp.dto.Employee;

import java.util.List;

public interface EmployeeServices {
    List<Employee> getEmployees();
    Employee getEmployee(Long id);
    Employee addEmployee(String name, double salary);
    void deleteEmployee(Long id);
    Employee updateEmployeeSalary(Long id, double salary);
}
