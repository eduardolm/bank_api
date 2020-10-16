package com.example.bank.service;

import com.example.bank.dto.Address;
import com.example.bank.entity.AddressEntity;
import com.example.bank.enums.Status;
import com.example.bank.repository.AddressRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AddressService {
    private AddressRepository addressRepository;
    private ObjectMapper objectMapper;
    private ProposalService proposalService;

    public AddressService(AddressRepository addressRepository, ObjectMapper objectMapper, ProposalService proposalService) {
        this.addressRepository = addressRepository;
        this.objectMapper = objectMapper;
        this.proposalService = proposalService;
    }

    public void createAddress(Address address) {
        AddressEntity addressEntity = objectMapper.convertValue(address, AddressEntity.class);
        var related_proposal = proposalService.getProposal(address.getId());
        related_proposal.setStatus(Status.UNDER_ANALYSIS_DATA);
        addressEntity.setProposal(related_proposal);
        addressRepository.save(addressEntity);
    }

    public List<AddressEntity> getAddresses() {
        List<AddressEntity> all = addressRepository.findAll();
        return all;
    }

    public Address getAddress(UUID id) {
        Address address = objectMapper.convertValue(addressRepository.findById(id).orElseThrow(), Address.class);
        return address;
    }
}
