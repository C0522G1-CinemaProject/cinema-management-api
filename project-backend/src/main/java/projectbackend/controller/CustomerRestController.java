package projectbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projectbackend.dto.customer.ICustomerStatementDto;
import projectbackend.service.customer.ICustomerService;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
@CrossOrigin("*")
public class CustomerRestController {

    @Autowired
    private ICustomerService customerService;


    /**
     * creator: Phan Phước Đại
     * method use statistical top customer positive
     */
    @GetMapping("/statement")
    public ResponseEntity<List<ICustomerStatementDto>> getCustomerTop(@RequestParam(defaultValue = "0") int numberMonth) {
        if (numberMonth < 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<ICustomerStatementDto> customerStatementDtoPage = customerService.getCustomerTop(numberMonth);
        if (customerStatementDtoPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(customerStatementDtoPage, HttpStatus.OK);
    }
}
