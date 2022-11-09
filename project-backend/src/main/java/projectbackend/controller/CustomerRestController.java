package projectbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projectbackend.dto.customer.ICustomerDto;
import projectbackend.service.customer.ICustomerService;
import projectbackend.service.customer.ICustomerTypeService;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/customer")
public class CustomerRestController {

    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private ICustomerTypeService iCustomerTypeService;

    @GetMapping("/{id}")
    public ResponseEntity<ICustomerDto> getCustomer(@PathVariable Integer id) {
        Optional<ICustomerDto> customerDto = iCustomerService.findCustomerById(id);
        if (customerDto.isPresent()) {
            return new ResponseEntity<>(customerDto.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
