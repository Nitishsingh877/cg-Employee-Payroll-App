package com.bridelabz.nitish.employeepayrollapp.Controller;

import com.bridelabz.nitish.employeepayrollapp.dto.Employee;
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
    public Employee getEmployee(@PathVariable("id") Long id) {
        return employeeRepository.findById(id).get();
    }

    @GetMapping("/get")
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @PostMapping("/add")
    public Employee addEmployee( @Valid  @RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteEmployee(@PathVariable("id") Long id) {
       if(employeeRepository.existsById(id)) {
           employeeRepository.deleteById(id);
           return true;
       }
       return false;
    }
}
