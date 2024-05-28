package ro.ccar.employeeservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ro.ccar.employeeservice.client.AddressClient;
import ro.ccar.employeeservice.dto.AddressResponse;
import ro.ccar.employeeservice.service.EmployeeService;
import ro.ccar.employeeservice.dto.EmployeeResponse;

@RestController
@AllArgsConstructor
public class EmployeeRestController {

    private final EmployeeService employeeService;

    private final AddressClient addressClient;

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable("name") String name) {
        return "Hello " + name;
    }

    @GetMapping("/employees")
    public ResponseEntity<EmployeeResponse> genericEmployeeResponse() {
        EmployeeResponse employeeResponse = new EmployeeResponse();
        employeeResponse.setId(1);
        employeeResponse.setName("John");
        employeeResponse.setEmail("john@mail.com");
        employeeResponse.setAge("25");
        return ResponseEntity.status(HttpStatus.OK).body(employeeResponse);
    }

    @GetMapping("/service")
    public ResponseEntity<EmployeeResponse> getEmployeeFromService() {
        EmployeeResponse employeeResponse = employeeService.defaultGetEmployee();
        return ResponseEntity.status(HttpStatus.OK).body(employeeResponse);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<EmployeeResponse> getEmployeeById(@PathVariable("id") int id) {
        EmployeeResponse employee = employeeService.getEmployeeById(id);
        AddressResponse address = getAddressForId(id);
        if (address != null) {
            employee.setAddressResponse(address);
        }
        return ResponseEntity.status(HttpStatus.OK).body(employee);
    }

    private AddressResponse getAddressForId(int id) {
        ResponseEntity<AddressResponse> addressByEmployeeId = addressClient.getAddressByEmployeeId(id);
        if (addressByEmployeeId.getStatusCode().is2xxSuccessful()) {
        return addressByEmployeeId.getBody();
        }
        return new AddressResponse();
    }
}
