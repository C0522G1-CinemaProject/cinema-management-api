package projectbackend.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import projectbackend.dto.employee.EmployeeDto;
import projectbackend.model.employee.Employee;
import projectbackend.service.employee.IEmployeeService;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/employee")
public class EmployeeRestController {
    @Autowired
    private IEmployeeService employeeService;


    @PostMapping("/create")
    public ResponseEntity<List<FieldError>> createEmployee(@Valid @RequestBody EmployeeDto employeeDto,
                                                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(),
                    HttpStatus.BAD_REQUEST);
        }
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

