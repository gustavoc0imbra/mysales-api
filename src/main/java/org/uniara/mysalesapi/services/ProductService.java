package org.uniara.mysalesapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.uniara.mysalesapi.models.Product;
import org.uniara.mysalesapi.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() { return productRepository.findAll(); }

    public Product save(Product product) { return productRepository.save(product); }

    public Optional<Product> findById(Long id) { return productRepository.findById(id); }

    public void deleteById(Long id) { productRepository.deleteById(id); }
}

