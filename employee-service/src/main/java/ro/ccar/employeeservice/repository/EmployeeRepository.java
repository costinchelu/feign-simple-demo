package ro.ccar.employeeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.ccar.employeeservice.entity.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
