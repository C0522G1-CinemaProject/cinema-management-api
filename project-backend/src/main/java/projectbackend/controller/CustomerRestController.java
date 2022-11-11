package projectbackend.controller;

<<<<<<< HEAD
=======
import org.springframework.beans.BeanUtils;
>>>>>>> a349e91ab233bd662eb3b822f5229e701bf146eb
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.*;
import projectbackend.dto.ticket.ITicketDto;
import projectbackend.model.ticket.Ticket;
import projectbackend.service.ticket.ITicketService;

import java.util.Optional;
=======
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import projectbackend.dto.customer.CustomerDto;
import projectbackend.model.customer.Customer;
import projectbackend.service.customer.ICustomerService;
import projectbackend.service.customer.ICustomerTypeService;
>>>>>>> a349e91ab233bd662eb3b822f5229e701bf146eb

import javax.validation.Valid;

@CrossOrigin
@RestController
<<<<<<< HEAD
@CrossOrigin("*")
@RequestMapping("api")
public class CustomerRestController {
    @Autowired
    ITicketService iTicketService;

    @GetMapping("/booking/ticket")
    public ResponseEntity<Page<ITicketDto>> showListBookingTicket(@PageableDefault(value = 5) Pageable pageable) {
        Page<ITicketDto> ticketPage = iTicketService.findAllBookingTickets(pageable, "abristog");
        if (ticketPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(ticketPage, HttpStatus.OK);
    }

    @GetMapping("/canceled/ticket")
    public ResponseEntity<Page<ITicketDto>> showListCanceledTicket(@PageableDefault(value = 5) Pageable pageable) {
        Page<ITicketDto> ticketPage = iTicketService.findAllCanceledTickets(pageable, "admin");
        if (ticketPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(ticketPage, HttpStatus.OK);
    }


    @GetMapping("/history/point")
    public ResponseEntity<Page<ITicketDto>> showListHistoryPoint(
            @PageableDefault(value = 5) Pageable pageable,
            @RequestParam(value = "bookingTime", defaultValue = "", required = false) String bookingTime,
            @RequestParam(value = "price", defaultValue = "0") int value) {

        Page<ITicketDto> historyPointSearch;
        if (value == 0) {
            historyPointSearch = iTicketService.findAllHistoryPoint("abristog", bookingTime, pageable);
        } else {
            historyPointSearch = iTicketService.findAllHistoryPointSearch("abristog", bookingTime, value, pageable);
        }

        if (historyPointSearch.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(historyPointSearch, HttpStatus.OK);

    }


    @DeleteMapping("delete/ticket/{id}")
    public ResponseEntity<Ticket> deleteTicket(@PathVariable Integer id) {
        Optional<Ticket> ticket = iTicketService.findByIdTicKet(id);
        System.out.println(iTicketService.findByIdTicKet(id).get());
        if (ticket.isPresent()) {
            iTicketService.deleteTicket(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
=======
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
>>>>>>> a349e91ab233bd662eb3b822f5229e701bf146eb
