package crm.crm.service;

import crm.crm.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee getEmployeeById(Long id);
    Employee saveEmployee(Employee employee);
    void deleteEmployee(Long id);
    Employee updateEmployee(Long id, Employee employeeDetails);
}