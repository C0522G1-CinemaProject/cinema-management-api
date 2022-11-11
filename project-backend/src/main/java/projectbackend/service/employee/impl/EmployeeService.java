package projectbackend.service.employee.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projectbackend.dto.employee.EmployeeDto;
import projectbackend.dto.employee.IEmployeeDto;
import projectbackend.model.employee.Employee;
import projectbackend.repository.employee.IEmployeeRepository;
import projectbackend.service.employee.IEmployeeService;

import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository employeeRepository;

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Optional<Employee> findEmployeeById(Integer id) {
        return employeeRepository.findEmployeeById(id);
    }

    @Override
    public Optional<Employee> findById(Integer id) {
        return employeeRepository.findById(id);
    }

//    @Override
//    public IEmployeeDto findById(Integer id) {
//        return employeeRepository.findEmployeeById(id);
//    }
}
