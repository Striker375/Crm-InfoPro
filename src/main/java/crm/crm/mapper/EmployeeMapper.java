package crm.crm.mapper;

import crm.crm.DTO.EmployeeDTO;
import crm.crm.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    @Mapping(source = "name", target = "name")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "position", target = "position")
    EmployeeDTO employeeToEmployeeDTO(Employee employee);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "position", target = "position")
    Employee employeeDTOToEmployee(EmployeeDTO employeeDTO);
}
