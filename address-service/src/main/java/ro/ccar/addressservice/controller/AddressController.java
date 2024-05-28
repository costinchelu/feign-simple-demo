package ro.ccar.addressservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ro.ccar.addressservice.dto.AddressResponse;
import ro.ccar.addressservice.service.AddressService;

@RestController
@AllArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @GetMapping("/addresses/{id}")
    public ResponseEntity<AddressResponse> getAddressById(@PathVariable int id) {
        AddressResponse response = addressService.findAddressById(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
