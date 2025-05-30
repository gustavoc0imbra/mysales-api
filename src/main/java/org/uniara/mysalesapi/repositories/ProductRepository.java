package org.uniara.mysalesapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.uniara.mysalesapi.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
