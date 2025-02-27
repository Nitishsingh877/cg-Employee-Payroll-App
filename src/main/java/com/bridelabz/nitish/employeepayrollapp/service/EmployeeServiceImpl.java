package com.bridelabz.nitish.employeepayrollapp.service;


import com.bridelabz.nitish.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridelabz.nitish.employeepayrollapp.entities.EmployeePayrollData;
import com.bridelabz.nitish.employeepayrollapp.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeServices{

    @Autowired
    private EmployeeRepository employeeRepository;

//private List<EmployeePayrollData> employeePayrollDataList = new ArrayList<>();
   @Override
   public List<EmployeePayrollData> getEmployeePayrollDataList() {
       return employeeRepository.findAll();
   }

    @Override
    public Optional<EmployeePayrollData> getEmployee(int id) {
        return employeeRepository.findById(id);
    }

    @Override
    public void deleteEmployee(int id) {
         employeeRepository.deleteById(id);
    }

    @Override
    public EmployeePayrollData addEmployee(EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData employeePayrollData = new EmployeePayrollData(employeePayrollDTO);
        log.debug("Employee payroll data: {}", employeePayrollData);
        return employeeRepository.save(employeePayrollData);
    }

    @Override
    public EmployeePayrollData updateEmployeeSalary(int empid, EmployeePayrollDTO employeePayrollDTO) {
       EmployeePayrollData employeePayrollData = this.getEmployee(empid).get();
       return employeeRepository.save(employeePayrollData);


    }
}
