package org.uniara.mysalesapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.uniara.mysalesapi.models.Address;
import org.uniara.mysalesapi.models.Customer;
import org.uniara.mysalesapi.repositories.AddressRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    public List<Address> findAllByCustomerId(Long id) {
        return addressRepository.findAllByCustomer_Id(id);
    }

    public Address save(Address address) {
        return addressRepository.save(address);
    }

    public Optional<Address> findById(Long id) {
        return addressRepository.findById(id);
    }

    public Optional<Address> findByIdAndCustomerId(Long id, Long customerId) {
        return addressRepository.findByIdAndCustomer_Id(id, customerId);
    }

    public void deleteById(Long id) {
        addressRepository.deleteById(id);
    }
}
