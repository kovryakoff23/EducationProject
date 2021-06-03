package com.Magazine.service;

import com.Magazine.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Magazine.repository.AddressRepository;

import java.util.List;
@Service
public class ServiceAddress implements ServiceMag<Address> {
    @Autowired
    AddressRepository addressRepository;
    @Override
    public Address get(long addressId) {
        return addressRepository.getOne(addressId);
    }

    @Override
    public List<Address> getAll() {
        return addressRepository.findAll();
    }

    @Override
    public void save(Address entity) {
        addressRepository.save(entity);
    }

    @Override
    public void delete(long addressId) {
        addressRepository.deleteById(addressId);
    }
}
