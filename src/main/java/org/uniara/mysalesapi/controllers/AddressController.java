package org.uniara.mysalesapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.uniara.mysalesapi.DTOs.ResponseAddressDTO;
import org.uniara.mysalesapi.DTOs.ResponseViaCepAddressDTO;
import org.uniara.mysalesapi.DTOs.SaveAddressDTO;
import org.uniara.mysalesapi.DTOs.UpdateAddressDTO;
import org.uniara.mysalesapi.constants.Constant;
import org.uniara.mysalesapi.models.Address;
import org.uniara.mysalesapi.models.Customer;
import org.uniara.mysalesapi.services.AddressService;
import org.uniara.mysalesapi.services.CustomerService;
import org.uniara.mysalesapi.services.ViaCepService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class AddressController {
    @Autowired
    private ViaCepService viaCepService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private CustomerService customerService;

    @GetMapping(Constant.API_URL + "/address/{cep}")
    public ResponseEntity<ResponseViaCepAddressDTO> getAddress(@PathVariable("cep") String cep) {
        return ResponseEntity.ok(viaCepService.getAddress(cep));
    }

    @GetMapping(Constant.API_CUSTOMERS_ADDRESSES)
    public ResponseEntity<List<Address>> findAll(@PathVariable("customerId") Long id) {
        return ResponseEntity.ok(addressService.findAllByCustomerId(id));
    }

    @PostMapping(Constant.API_CUSTOMERS_ADDRESSES)
    public ResponseEntity<ResponseAddressDTO> save(@PathVariable("customerId") Long customerId, @RequestBody SaveAddressDTO dto) {
        Optional<Customer> customer = customerService.findById(customerId);

        if (customer.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found");
        }

        Address address = new Address(dto.getDescription(), dto.getZipCode(), dto.getStreet(), dto.getAddressNumber(), dto.getNeighborhood(), dto.getCity());

        address.setCustomer(customer.get());
        address = addressService.save(address);
        ResponseAddressDTO response = new ResponseAddressDTO(address.getId(), address.getCustomer().getId(), address.getDescription(), address.getZipCode(), address.getStreet(), address.getAddressNumber(), address.getNeighborhood(), address.getCity());

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping(Constant.API_CUSTOMERS_ADDRESSES + "/{addressId}")
    public ResponseEntity<Optional<Address>> findByIdAndCustomer(@PathVariable("addressId") Long id, @PathVariable("customerId") Long customerId) {
        return ResponseEntity.ok(addressService.findByIdAndCustomerId(id, customerId));
    }

    @PutMapping(Constant.API_CUSTOMERS_ADDRESSES)
    public ResponseEntity<ResponseAddressDTO> update(@PathVariable("customerId") Long customerId, @RequestBody UpdateAddressDTO dto) {
        if (customerService.findById(customerId).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found");
        }

        Optional<Address> address = addressService.findByIdAndCustomerId(dto.getId(), customerId);

        if (address.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Address not found");
        }
        
        address.get().setId(address.get().getId());
        address.get().setCustomer(address.get().getCustomer());
        address.get().setDescription(dto.getDescription());
        address.get().setZipCode(dto.getZipCode());
        address.get().setCity(dto.getCity());
        address.get().setStreet(dto.getStreet());
        address.get().setAddressNumber(dto.getAddressNumber());
        address.get().setNeighborhood(dto.getNeighborhood());

        Address update = addressService.save(address.get());

        ResponseAddressDTO response = new ResponseAddressDTO(update.getId(), update.getCustomer().getId(), address.get().getDescription(), address.get().getZipCode(), address.get().getStreet(), address.get().getAddressNumber(), address.get().getNeighborhood(), address.get().getCity());

        return ResponseEntity.ok(response);
    }

    @DeleteMapping(Constant.API_CUSTOMERS_ADDRESSES + "/{addressId}")
    public ResponseEntity<Address> deleteById(@PathVariable("addressId") Long id) {
        addressService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
