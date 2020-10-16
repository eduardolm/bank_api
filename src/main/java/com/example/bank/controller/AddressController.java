package com.example.bank.controller;

import com.example.bank.dto.Address;
import com.example.bank.entity.AddressEntity;
import com.example.bank.service.AddressService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("v1/address")
public class AddressController {
    private AddressService addressService;
    private ObjectMapper objectMapper;

    public AddressController(AddressService addressService, ObjectMapper objectMapper) {
        this.addressService = addressService;
        this.objectMapper = objectMapper;
    }

    @GetMapping
    public ResponseEntity<List<AddressEntity>> getAddresses() {
        List<AddressEntity> addressEntityList = addressService.getAddresses();
        return ResponseEntity.status(HttpStatus.OK).body(addressEntityList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> getAddress(@PathVariable() UUID id) {
        Address address = addressService.getAddress(id);
        return ResponseEntity.status(HttpStatus.OK).body(address);
    }

    @PostMapping
    public ResponseEntity createAddress(@Valid @RequestBody Address address) {
        addressService.createAddress(address);;
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
