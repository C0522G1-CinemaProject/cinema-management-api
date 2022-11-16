package projectbackend.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import projectbackend.dto.customer.CustomerDto;
import projectbackend.dto.customer.ICustomerDto;
import projectbackend.model.customer.Customer;
import projectbackend.model.decentralization.User;
import projectbackend.service.customer.ICustomerService;
import projectbackend.service.decentralization.impl.MyUserDetails;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/customer")
public class CustomerRestController {


    @Autowired
    private ICustomerService iCustomerService;

    @GetMapping("/find-username")
    public ResponseEntity<ICustomerDto> getCustomer() {
        String username = ((MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        Optional<ICustomerDto> customerDto = iCustomerService.findCustomerByUsername(username);
        User user = new User();
        user.setPassword("");
        if (customerDto.isPresent()) {
            return new ResponseEntity<>(customerDto.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/add")
    public ResponseEntity<?> saveCustomer(@RequestBody @Valid CustomerDto customerDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(),
                    HttpStatus.BAD_REQUEST);
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        customer.getUser().setPassword(new BCryptPasswordEncoder().encode(customerDto.getUser().getPassword()));
        iCustomerService.saveCustomer(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/list")
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

    @PatchMapping("/edit")
    public ResponseEntity<?> editCustomer(@RequestBody @Valid CustomerDto customerDto,
                                                         BindingResult bindingResult,
                                                         @RequestParam(value = "username") String username
    ) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldError(),
                    HttpStatus.BAD_REQUEST);
        } else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            iCustomerService.update(customer, username);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

}

