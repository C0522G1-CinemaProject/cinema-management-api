package projectbackend.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import projectbackend.dto.customer.CustomerDto;
import projectbackend.model.customer.Customer;
import projectbackend.service.customer.ICustomerService;
import projectbackend.service.customer.ICustomerTypeService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/customer")
public class CustomerRestController {

    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private ICustomerTypeService iCustomerTypeService;

    @GetMapping("")
    public ResponseEntity<Page<Customer>> showList(@PageableDefault(value = 5) Pageable pageable,
                                                   @RequestParam(value = "nameSearch", defaultValue = "") String nameSearch,
                                                   @RequestParam(value = "addressSearch", defaultValue = "") String addressSearch,
                                                   @RequestParam(value = "phoneSearch", defaultValue = "") String phoneSearch) {
        Page<Customer> customerPage = iCustomerService.searchCustomer(nameSearch, addressSearch, phoneSearch, pageable);
        if (customerPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customerPage, HttpStatus.OK);
    }

    @PatchMapping("/edit/{id}")
    public ResponseEntity<?> editCustomer(@RequestBody @Valid CustomerDto customerDto,
                                          BindingResult bindingResult,
                                          Integer id
    ) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldError(),
                    HttpStatus.BAD_REQUEST);
        } else {
            Customer customer = new Customer();
            customer.setId(id);
            BeanUtils.copyProperties(customerDto, customer);
            iCustomerService.update(customer);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Customer> editCustomer(@PathVariable Integer id) {
        Customer customer = iCustomerService.findByIdCustomer(id).get();
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
}
