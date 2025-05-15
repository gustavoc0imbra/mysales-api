package org.uniara.mysalesapi.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Customer {
    @Id
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private boolean active;
}
