package projectbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projectbackend.dto.customer.ICustomerStatementDto;
import projectbackend.service.customer.ICustomerService;

@RestController
@RequestMapping("/api/customer")
public class CustomerRestController {

    @Autowired
    private ICustomerService customerService;

    @GetMapping("/statement")
    public ResponseEntity<Page<ICustomerStatementDto>> getCustomerTop(@PageableDefault(value = 20) Pageable pageable) {
        Page<ICustomerStatementDto> customerStatementDtoPage = customerService.getCustomerTop(pageable);
        if (customerStatementDtoPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customerStatementDtoPage, HttpStatus.OK);
    }
}
