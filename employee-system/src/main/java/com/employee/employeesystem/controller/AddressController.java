package com.employee.employeesystem.controller;

import com.employee.employeesystem.model.Address;
import com.employee.employeesystem.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/address")
public class AddressController {
    private AddressService addressService;
    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }
    @GetMapping("/get")
    public List<Address> findAllAddress() {
        return addressService.findAll();
    }
    @GetMapping("/get/{addressId}")
    public Address findAddressById(@PathVariable Long addressId) {
        return addressService.findById(addressId);
    }
    @PostMapping("/create")
    public Address addNewAddress(@RequestBody Address address) {
        return addressService.addAddress(address);
    }
    @PutMapping("/edit")
    public Address editAddress(@RequestBody Address address) {
        return addressService.save(address);
    }
    @DeleteMapping("/delete/{addressId}")
    public String deleteEmployee(@PathVariable Long addressId) {
        int n = addressService.findAll().size();
        if (addressId > n || addressId <0) {
            throw new RuntimeException("address with id " + addressId + " does not exist.");
        }
        else {
            addressService.deleteById(addressId);
        }
        return "Delete Address Succesfully";
    }
}
