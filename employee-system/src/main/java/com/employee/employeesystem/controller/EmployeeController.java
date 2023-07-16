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
    public ResponseEntity<List<Employee>> getAllEmployee() {
       List<Employee> employees = employeeService.findAll();
       return new ResponseEntity<>(employees, HttpStatus.OK);
    }
    @GetMapping("/get/{employeeId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long employeeId) {
        Employee employee =employeeService.findById(employeeId);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee employee1 = employeeService.addEmployee(employee);
        return new ResponseEntity<>(employee1, HttpStatus.CREATED);
    }
    @PutMapping("/update/{employeeId}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable Long employeeId) {
        Employee employee1 = employeeService.updateEmployee(employee, employeeId);
        return new ResponseEntity<>(employee1, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{employeeId}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable Long employeeId) {
        employeeService.findById(employeeId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
