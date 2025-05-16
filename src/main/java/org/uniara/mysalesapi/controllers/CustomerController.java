package org.uniara.mysalesapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.uniara.mysalesapi.constants.Constant;
import org.uniara.mysalesapi.models.Customer;
import org.uniara.mysalesapi.services.CustomerService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping(Constant.API_CUSTOMERS)
    public ResponseEntity<List<Customer>> findAll() {
        return ResponseEntity.ok(customerService.findAll());
    }

    @PostMapping(Constant.API_CUSTOMERS)
    public ResponseEntity<Customer> save(@RequestBody Customer customer) {
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.save(customer));
    }

    @PutMapping(Constant.API_CUSTOMERS)
    public ResponseEntity<Customer> update(@RequestBody Customer customer) {
        return ResponseEntity.ok(customerService.save(customer));
    }

    @GetMapping(Constant.API_CUSTOMERS + "/{id}")
    public ResponseEntity<Optional<Customer>> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(customerService.findById(id));
    }

    @DeleteMapping(Constant.API_CUSTOMERS + "/{id}")
    public ResponseEntity<Customer> deleteById(@PathVariable("id") Long id) {
        customerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
