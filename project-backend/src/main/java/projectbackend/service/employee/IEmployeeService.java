package projectbackend.service.employee;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import projectbackend.dto.employee.EmployeeDto;
import projectbackend.dto.employee.IEmployeeDto;
import projectbackend.model.employee.Employee;

import java.util.Optional;

public interface IEmployeeService {

    Page<Employee> findAllEmployee(Pageable pageable);
    Page<Employee> findAllEmployee(Pageable pageable, String search);
    void deleteEmployee(Integer id);

    void saveEmployee(Employee employee);

    Optional<Employee> findEmployeeById(Integer id);

    Optional<Employee> findById(Integer id);


}
