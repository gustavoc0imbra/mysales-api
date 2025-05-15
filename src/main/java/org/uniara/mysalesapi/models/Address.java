package org.uniara.mysalesapi.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter
@ToString
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Customer customer;
    private String description;
    private String zipCode;
    private String street;
    private String addressNumber;
    private String neighborhood;
    private String city;
}
