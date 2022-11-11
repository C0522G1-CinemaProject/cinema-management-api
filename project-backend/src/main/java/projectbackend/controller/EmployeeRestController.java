package projectbackend.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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

    @GetMapping("/list")
    public ResponseEntity<Page<Employee>> findAllEmployee(@PageableDefault(size = 4) Pageable pageable, @RequestParam(defaultValue = "") String search) {
        Page<Employee> employeePage = employeeService.findAllEmployee(pageable, search);
        if (employeePage.hasContent()) {
            return new ResponseEntity<>(employeePage, HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable int id) {
        this.employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
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
    public ResponseEntity<List<FieldError>> saveEditing(@Valid @RequestBody EmployeeDto employeeDto,
                                                @PathVariable Integer id, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(),
                    HttpStatus.BAD_REQUEST);
        }
        Employee employee = employeeService.findEmployeeById(id).get();
        BeanUtils.copyProperties(employeeDto, employee);
        employeeService.saveEmployee(employee);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable Integer id) {
        Employee employee = employeeService.findEmployeeById(id).get();
        EmployeeDto employeeDto = new EmployeeDto();
        BeanUtils.copyProperties(employee, employeeDto);
        return new ResponseEntity<>(employeeDto, HttpStatus.OK);
    }


}

