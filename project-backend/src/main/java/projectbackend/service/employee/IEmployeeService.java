package projectbackend.service.employee;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import projectbackend.model.employee.Employee;

import java.util.Optional;

public interface IEmployeeService {
    Page<Employee> findAllEmployee(Pageable pageable);
    Page<Employee> findAllEmployee(Pageable pageable, String search);
    Optional<Employee> findEmployeeById(Integer id);
    void deleteEmployee(Integer id);
}
