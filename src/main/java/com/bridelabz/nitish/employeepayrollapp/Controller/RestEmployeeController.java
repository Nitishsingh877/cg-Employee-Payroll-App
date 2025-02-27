package com.bridelabz.nitish.employeepayrollapp.Controller;


import com.bridelabz.nitish.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridelabz.nitish.employeepayrollapp.entities.EmployeePayrollData;
import com.bridelabz.nitish.employeepayrollapp.repository.EmployeeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v4/employee")
public class RestEmployeeController {

   @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/get/{id}")
    public EmployeePayrollData getEmployee(@PathVariable("id") int id) {
        return employeeRepository.findById(id).get();
    }

    @GetMapping("/get")
    public List<EmployeePayrollData> getEmployees() {
        return employeeRepository.findAll();
    }

    @PostMapping("/add")
    public EmployeePayrollData addEmployee(@Valid  @RequestBody EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData employeePayrollData = new EmployeePayrollData(employeePayrollDTO);
        return employeeRepository.save(employeePayrollData);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteEmployee(@PathVariable("id") int id) {
       if(employeeRepository.existsById(id)) {
           employeeRepository.deleteById(id);
           return true;
       }
       return false;
    }

    @PutMapping("/update/{id}")
    public EmployeePayrollData updateEmployee( @Valid @PathVariable Long id,@Valid @RequestBody EmployeePayrollDTO employeePayrollDTO) {
          EmployeePayrollData employeePayrollData = new EmployeePayrollData(employeePayrollDTO);
          employeeRepository.save(employeePayrollData);
          return employeePayrollData;
    }

    @GetMapping("/dept/{departments}")
    public List<EmployeePayrollData> getEmployeeByDepartments(@PathVariable("departments") String departments) {
        return employeeRepository.findEmployeeByDepartments(departments);
    }
}
