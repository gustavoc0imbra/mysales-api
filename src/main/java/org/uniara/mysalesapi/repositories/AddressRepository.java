package org.uniara.mysalesapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.uniara.mysalesapi.models.Address;

import java.util.List;
import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    List<Address> findAllByCustomer_Id(Long customerId);
    Optional<Address> findByIdAndCustomer_Id(Long id, Long customerId);
}
