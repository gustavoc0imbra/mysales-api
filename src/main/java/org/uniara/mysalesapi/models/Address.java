package org.uniara.mysalesapi.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@Getter @Setter
@ToString
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Customer customer;
    @NonNull
    private String description;
    @NonNull
    private String zipCode;
    @NonNull
    private String street;
    @NonNull
    private String addressNumber;
    @NonNull
    private String neighborhood;
    @NonNull
    private String city;
}
