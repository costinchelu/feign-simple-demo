package ro.ccar.employeeservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ro.ccar.employeeservice.dto.EmployeeResponse;
import ro.ccar.employeeservice.entity.Employee;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

//    @Mapping(target = "id", source = "id")
//    @Mapping(target = "name", source = "name")
//    @Mapping(target = "email", source = "email")
//    @Mapping(target = "age", source = "age")
    EmployeeResponse empToResp(Employee e);
}
