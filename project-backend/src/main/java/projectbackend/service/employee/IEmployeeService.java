package projectbackend.service.employee;

import projectbackend.dto.employee.EmployeeDto;
import projectbackend.dto.employee.IEmployeeDto;
import projectbackend.model.employee.Employee;

import java.util.Optional;

public interface IEmployeeService {

    void saveEmployee(Employee employee);

    Optional<Employee> findEmployeeById(Integer id);

    Optional<Employee> findById(Integer id);

}
