package ro.ccar.addressservice.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ro.ccar.addressservice.dto.AddressResponse;
import ro.ccar.addressservice.entity.Address;
import ro.ccar.addressservice.mapper.AddressMapper;
import ro.ccar.addressservice.repository.AddressRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;

    private final AddressMapper addressMapper;

    public AddressResponse findAddressById(int id) {
        Optional<Address> addressById = addressRepository.findById(id);
        return addressMapper.addressToResponse(addressById.orElseGet(Address::new));
    }
}
