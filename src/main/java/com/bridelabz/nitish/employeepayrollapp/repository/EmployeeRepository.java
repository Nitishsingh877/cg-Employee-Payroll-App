package com.bridelabz.nitish.employeepayrollapp.repository;


import com.bridelabz.nitish.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridelabz.nitish.employeepayrollapp.entities.EmployeePayrollData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeePayrollData, Integer> {

}
