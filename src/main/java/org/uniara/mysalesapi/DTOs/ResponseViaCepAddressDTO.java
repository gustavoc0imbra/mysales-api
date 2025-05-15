package org.uniara.mysalesapi.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter @Setter
@ToString
public class ResponseViaCepAddressDTO {
    private String zipCode;
    private String street;
    private String neighborhood;
    private String city;
}
