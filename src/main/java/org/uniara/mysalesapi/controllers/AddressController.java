package org.uniara.mysalesapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.uniara.mysalesapi.DTOs.ResponseViaCepAddressDTO;
import org.uniara.mysalesapi.constants.Constant;
import org.uniara.mysalesapi.services.ViaCepService;

@RestController
public class AddressController {
    @Autowired
    private ViaCepService viaCepService;

    @GetMapping(Constant.API_URL + "/address/{cep}")
    public ResponseEntity<ResponseViaCepAddressDTO> getAddress(@PathVariable("cep") String cep) {
        return ResponseEntity.ok(viaCepService.getAddress(cep));
    }
}
