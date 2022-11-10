package projectbackend.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projectbackend.dto.employee.EmployeeDto;
import projectbackend.model.employee.Employee;
import projectbackend.service.employee.IEmployeeService;

@RestController
@CrossOrigin
@RequestMapping("/employee")
public class EmployeeRestController {
    @Autowired
    private IEmployeeService employeeService;


    @PostMapping("/create")
    public ResponseEntity<Employee> createEmployee(@RequestBody EmployeeDto employeeDto) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);
        employeeService.saveEmployee(employee);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @PatchMapping("/edit/{id}")
    public ResponseEntity<Employee> saveEditing(@RequestBody EmployeeDto employeeDto,
                                                @PathVariable int id) {
        Employee employee = employeeService.findEmployeeById(id).get();
        BeanUtils.copyProperties(employeeDto, employee);
        employeeService.saveEmployee(employee);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable int id) {
        Employee employee = employeeService.findEmployeeById(id).get();
        EmployeeDto employeeDto = new EmployeeDto();
        BeanUtils.copyProperties(employee, employeeDto);
        return new ResponseEntity<>(employeeDto, HttpStatus.OK);
    }


}

