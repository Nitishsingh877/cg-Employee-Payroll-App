package com.bridelabz.nitish.employeepayrollapp.service;

import com.bridelabz.nitish.employeepayrollapp.dto.Employee;
import com.bridelabz.nitish.employeepayrollapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeServices{
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployee(Long id) {
        if(employeeRepository.existsById(id)){
            return employeeRepository.findById(id).get();
        }else {
            return null;
        }
    }

    @Override
    public Employee addEmployee(String name, double salary) {
         Employee employee = new Employee(name, salary);
         return employeeRepository.save(employee);

    }

    @Override
    public void deleteEmployee(Long id) {
        if(employeeRepository.existsById(id)){
            employeeRepository.deleteById(id);
        }

    }
}
