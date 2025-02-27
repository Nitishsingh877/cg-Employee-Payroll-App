//package com.bridelabz.nitish.employeepayrollapp.Controller;
//
//
//import com.bridelabz.nitish.employeepayrollapp.dto.EmployeePayrollDTO;
//import com.bridelabz.nitish.employeepayrollapp.repository.EmployeeRepository;
//import com.bridelabz.nitish.employeepayrollapp.service.EmployeeServices;
//import jakarta.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/employee")
//public class EmployeeController {
//
////    @Autowired
////    private EmployeeRepository repository;
//    @Autowired
//    private EmployeeServices employeeServices;
//
//    // Show Employee Page
//    @GetMapping
//    public String showEmployees(Model model) {
//        model.addAttribute("employees", employeeServices.getEmployeePayrollDataList());
//        return "employee";
//    }
//
//    // Add Employee
//    @PostMapping("/add")
//    public String addEmployee(@Valid  @RequestBody EmployeePayrollDTO employeePayrollDTO) {
//        employeeServices.addEmployee(employeePayrollDTO);
//        return "redirect:/employee";
//    }
//
//    // Delete Employee
//    @GetMapping("/delete/{id}")
//    public String deleteEmployee( @Valid @PathVariable int id) {
//        employeeServices.deleteEmployee(id);
//        return "redirect:/employee";
//    }
//
////    @PutMapping("/update/{id}")
////    public void updateEmployee( @Valid @PathVariable Long id,@Valid @RequestParam double salary) {
////        employeeServices.updateEmployeeSalary(id, salary);
////    }
//}
