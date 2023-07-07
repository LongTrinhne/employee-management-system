package com.employee.employeesystem.service;

import com.employee.employeesystem.model.Address;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AddressService {

    Address addAddress(Address address);
    List<Address> findAll();
    Address findById(Long addressId);
    Address save(Address address);
    String deleteById(Long addressId);
}
