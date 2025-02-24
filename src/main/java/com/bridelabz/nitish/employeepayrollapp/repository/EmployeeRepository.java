package com.bridelabz.nitish.employeepayrollapp.repository;

import com.bridelabz.nitish.employeepayrollapp.dto.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
