package projectbackend.service.employee;

import projectbackend.model.employee.Employee;

import java.util.Optional;

public interface IEmployeeService {

    void saveEmployee(Employee employee);

    Optional<Employee> findById(int id);
}
