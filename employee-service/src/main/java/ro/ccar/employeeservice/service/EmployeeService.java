package ro.ccar.employeeservice.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ro.ccar.employeeservice.dto.AddressResponse;
import ro.ccar.employeeservice.dto.EmployeeResponse;
import ro.ccar.employeeservice.entity.Employee;
import ro.ccar.employeeservice.mapper.EmployeeMapper;
import ro.ccar.employeeservice.repository.EmployeeRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final EmployeeMapper employeeMapper;

    public EmployeeResponse defaultGetEmployee() {
        EmployeeResponse employeeResponse = new EmployeeResponse();
        employeeResponse.setId(1);
        employeeResponse.setName("John");
        employeeResponse.setEmail("john@mail.com");
        employeeResponse.setAge("25");
        AddressResponse addressResponse = new AddressResponse();
        addressResponse.setId(1);
        addressResponse.setCity("Bucharest");
        addressResponse.setState("Romania");
        employeeResponse.setAddressResponse(addressResponse);
        return employeeResponse;
    }

    public EmployeeResponse getEmployeeById(int id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return employeeMapper.empToResp(employee.orElseGet(Employee::new));
    }
}
