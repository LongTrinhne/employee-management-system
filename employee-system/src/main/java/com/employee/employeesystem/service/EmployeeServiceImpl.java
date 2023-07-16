package com.employee.employeesystem.service;

import com.employee.employeesystem.exception.UserNotFoundException;
import com.employee.employeesystem.model.Employee;
import com.employee.employeesystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeRepository employeeRepository;
    private AddressService addressService;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, AddressService addressService) {
        this.employeeRepository = employeeRepository;
        this.addressService = addressService;
    }
    @Override
    public Employee addEmployee(Employee employee) {
        Employee employee1 = new Employee();
        employee1.setId(0L);
        employee1.setFirstName(employee.getFirstName());
        employee1.setLastName(employee.getLastName());
        employee1.setEmail(employee.getEmail());
        employee1.setAddress(employee.getAddress());

        return employeeRepository.save(employee1);
    }
    public Employee updateEmployee(Employee employee, Long empluyeeId) {
        Employee employee1 = findById(empluyeeId);
        employee1.setAddress(employee.getAddress());
        employee1.setFirstName(employee.getFirstName());
        employee1.setLastName(employee.getLastName());
        employee1.setEmail(employee.getEmail());
        return employeeRepository.save(employee1);
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(Long employeeId) {
        return employeeRepository.findById(employeeId).orElseThrow(() ->
                new UserNotFoundException("employee with id " + employeeId + " does not exist."));
    }
    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }
    @Override
    public String deleteById(Long employeeId) {
        Employee employee = findById(employeeId);
        if (employee == null) {
            throw new UserNotFoundException("address with id " + employeeId + " does not exist.");
        }
        else {
            employeeRepository.deleteById(employeeId);
        }
        return "employee with id " + employeeId + " has been deleted.";
    }
}
