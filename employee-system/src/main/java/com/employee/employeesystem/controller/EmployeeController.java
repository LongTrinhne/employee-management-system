package com.employee.employeesystem.controller;

import com.employee.employeesystem.model.Address;
import com.employee.employeesystem.model.Employee;
import com.employee.employeesystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    private EmployeeService employeeService;
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/get")
    public List<Employee> getAllEmployee() {
       return employeeService.findAll();
    }
    @GetMapping("/get/{employeeId}")
    public Employee getEmployeeById(@PathVariable Long employeeId) {
        return employeeService.findById(employeeId);
    }
    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }
}
