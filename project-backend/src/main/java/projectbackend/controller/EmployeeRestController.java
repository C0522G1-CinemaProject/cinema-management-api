package projectbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projectbackend.model.employee.Employee;
import projectbackend.service.employee.IEmployeeService;

@RestController
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

}
