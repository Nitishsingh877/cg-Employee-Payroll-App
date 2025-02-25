package com.bridelabz.nitish.employeepayrollapp.service;

import com.bridelabz.nitish.employeepayrollapp.dto.Employee;
import com.bridelabz.nitish.employeepayrollapp.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeServices{
    @Autowired
    private EmployeeRepository employeeRepository;

   // Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

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
    public Employee updateEmployeeSalary(Long id, double salary) {
        try {
            Optional<Employee> optionalEmployee = employeeRepository.findById(id);

            if (optionalEmployee.isPresent()) {
                Employee employee = optionalEmployee.get();
                employee.setSalary(salary);
                return employeeRepository.save(employee);
            } else {
                log.error("Employee with ID {} not found.", id);
                log.debug("Employee with ID {} not found.", id);
                log.warn("Employee with ID {} not found.", id);
                log.info("Employee with ID {} not found.", id);
                return null;
            }
        } catch (NoSuchElementException e) {
            log.error("Employee with ID {} not found.", id);
            log.debug("Employee with ID {} not found.", id);
            log.warn("Employee with ID {} not found.", id);
            log.info("Employee with ID {} not found.", id);
            return null;
        } catch (Exception e) {
            log.error("Error updating employee salary for ID {}: {}", id, e.getMessage());
            log.debug("Employee with ID {} not found.", id);
            log.warn("Employee with ID {} not found.", id);
            log.info("Employee with ID {} not found.", id);
            return null;
        }
    }


    @Override
    public void deleteEmployee(Long id) {
        if(employeeRepository.existsById(id)){
            employeeRepository.deleteById(id);
        }



    }
}
