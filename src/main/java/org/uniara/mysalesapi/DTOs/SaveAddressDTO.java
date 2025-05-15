package org.uniara.mysalesapi.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public class SaveAddressDTO {
    private String description;
    private String zipCode;
    private String street;
    private String addressNumber;
    private String neighborhood;
    private String city;
}
