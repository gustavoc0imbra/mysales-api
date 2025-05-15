package org.uniara.mysalesapi.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UpdateAddressDTO {
    private Long id;
    private String description;
    private String zipCode;
    private String street;
    private String addressNumber;
    private String neighborhood;
    private String city;
}
