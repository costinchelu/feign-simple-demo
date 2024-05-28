package ro.ccar.addressservice.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ro.ccar.addressservice.dto.AddressResponse;
import ro.ccar.addressservice.entity.Address;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "city", target = "city")
    @Mapping(source = "state", target = "state")
    AddressResponse addressToResponse(Address employee);
}
