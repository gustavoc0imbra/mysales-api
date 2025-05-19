package org.uniara.mysalesapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.uniara.mysalesapi.constants.Constant;
import org.uniara.mysalesapi.models.Product;
import org.uniara.mysalesapi.services.ProductService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping(Constant.API_PRODUCTS)
    public ResponseEntity<List<Product>> findAll() {
        return ResponseEntity.ok(productService.findAll());
    }

    @PostMapping(Constant.API_PRODUCTS)
    public ResponseEntity<Product> save(@RequestBody Product product) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(product));
    }

    @PutMapping(Constant.API_PRODUCTS)
    public ResponseEntity<Product> update(@RequestBody Product product) {
        return ResponseEntity.ok(productService.save(product));
    }

    @GetMapping(Constant.API_PRODUCTS + "/{id}")
    public ResponseEntity<Optional<Product>> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(productService.findById(id));
    }

    @DeleteMapping(Constant.API_PRODUCTS + "/{id}")
    public ResponseEntity<Product> deleteById(@PathVariable("id") Long id) {
        productService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
