package com.employee.employeesystem.service;

import com.employee.employeesystem.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    Employee addEmployee(Employee employee);
    List<Employee> findAll();
    Employee findById(Long employeeId);
    Employee save(Employee employee);
    String deleteById(Long employeeId);
}
