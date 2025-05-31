package org.uniara.mysalesapi.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter @Setter
@ToString
public class UpdateAddressDTO {
    private Long id;
    private String description;
    private String zipCode;
    private String street;
    private String addressNumber;
    private String neighborhood;
    private String city;
}
