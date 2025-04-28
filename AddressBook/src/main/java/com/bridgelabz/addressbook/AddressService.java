package com.bridgelabz.addressbook;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public List<AddressDTO> getAllAddresses() {
        log.info("Fetching all addresses");
        return addressRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<AddressDTO> getAddressById(Long id) {
        log.info("Fetching address with id: {}", id);
        return Optional.ofNullable(addressRepository.findById(id)
                .map(address -> {
                    log.debug("Found address: {}", address);
                    return convertToDTO(address);
                })
                .orElseThrow(() -> {
                    log.error("Address not found with id: {}", id);
                    return new AddressBookNotFoundException("Address not found with id: " + id);
                }));
    }

    public AddressDTO createAddress(AddressDTO addressDTO) {
        log.info("Creating address: {}", addressDTO);
        Address address = convertToEntity(addressDTO);
        Address savedAddress = addressRepository.save(address);
        log.debug("Saved address: {}", savedAddress);
        return convertToDTO(savedAddress);
    }

    public AddressDTO updateAddress(Long id, AddressDTO addressDTO) {
        log.info("Updating address with id: {}", id);
        if (!addressRepository.existsById(id)) {
            log.error("Address not found with id: {}", id);
            throw new AddressBookNotFoundException("Address not found with id: " + id);
        }
        Address address = convertToEntity(addressDTO);
        address.setId(id);
        Address updatedAddress = addressRepository.save(address);
        log.debug("Updated address: {}", updatedAddress);
        return convertToDTO(updatedAddress);
    }

    public void deleteAddress(Long id) {
        log.info("Deleting address with id: {}", id);
        if (!addressRepository.existsById(id)) {
            log.error("Address not found with id: {}", id);
            throw new AddressBookNotFoundException("Address not found with id: " + id);
        }
        addressRepository.deleteById(id);
        log.debug("Deleted address with id: {}", id);
    }

    private AddressDTO convertToDTO(Address address) {
        AddressDTO dto = new AddressDTO();
        dto.setId(address.getId());
        dto.setName(address.getName());
        dto.setStreet(address.getStreet());
        dto.setCity(address.getCity());
        return dto;
    }

    private Address convertToEntity(AddressDTO dto) {
        Address address = new Address();
        address.setId(dto.getId());
        address.setName(dto.getName());
        address.setStreet(dto.getStreet());
        address.setCity(dto.getCity());
        return address;
    }
}