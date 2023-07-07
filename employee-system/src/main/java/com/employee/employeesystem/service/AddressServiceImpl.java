package com.employee.employeesystem.service;

import com.employee.employeesystem.model.Address;
import com.employee.employeesystem.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService{
    private AddressRepository addressRepository;
    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }
    @Transactional
    @Override
    public Address addAddress(Address address) {
        Address address1 = new Address();
        address1.setId(0L);
        address1.setProvince(address.getProvince());
        address1.setStreet(address.getStreet());
        address1.setHouseNumber(address.getHouseNumber());
//        address1.setEmployee(address.getEmployee());
        return addressRepository.save(address1);
    }
    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }
    @Override
    public Address findById(Long addressId) {
        return addressRepository.findById(addressId).orElseThrow(() ->
                new RuntimeException("address with id " + addressId + " does not exist."));
    }
    @Transactional
    @Override
    public Address save(Address address) {
        return addressRepository.save(address);
    }
    @Transactional
    @Override
    public String deleteById(Long addressId) {
        Address address = findById(addressId);
        if (address == null) {
            throw new RuntimeException("address with id " + addressId + " does not exist.");
        }
        else {
            addressRepository.deleteById(addressId);
        }
        return "address with id " + addressId + " has been deleted.";
    }
}
