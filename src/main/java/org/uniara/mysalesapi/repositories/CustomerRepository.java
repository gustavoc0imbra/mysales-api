package org.uniara.mysalesapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.uniara.mysalesapi.models.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
