package ro.ccar.employeeservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ro.ccar.employeeservice.dto.AddressResponse;

@FeignClient(name = "address-service",
        url= "http://localhost:8092",
        configuration = FeignClientConfig.class)
@Component
public interface AddressClient {

    @GetMapping("/address-service/addresses/{id}")
    ResponseEntity<AddressResponse> getAddressByEmployeeId(@PathVariable("id") int id);
}
