package projectbackend.service.employee.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import projectbackend.dto.employee.IEmployeeDto;
import projectbackend.model.employee.Employee;
import projectbackend.repository.decentralization.IUserRepository;
import projectbackend.repository.employee.IEmployeeRepository;
import projectbackend.service.employee.IEmployeeService;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository employeeRepository;

    @Autowired
    private IUserRepository userRepository;

    @Override
    public Page<Employee> findAllEmployee(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public Page<Employee> findAllEmployee(Pageable pageable, String search) {
        return employeeRepository.findEmployeeByNameContaining(pageable, search);
    }


    @Override
    public void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public void saveEmployee(Employee employee) {
//        userRepository.createUser(employee.getUser());
        employeeRepository.saveEmployee(employee);
    }


    @Override
    public Optional<Employee> findEmployeeById(Integer id) {
        return employeeRepository.findEmployeeById(id);
    }

    @Override
    public Optional<Employee> findById(Integer id) {
        return employeeRepository.findById(id);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeRepository.updateEmployee(employee);
    }

}
