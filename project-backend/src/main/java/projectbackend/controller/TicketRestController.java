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
import projectbackend.dto.ticket.ITicketDto;
import projectbackend.dto.ticket.ITicketManagerDto;
import projectbackend.dto.ticket.TicketDto;
import projectbackend.model.ticket.Ticket;
import projectbackend.service.ticket.ITicketService;

import java.util.Optional;

@RestController
@RequestMapping("/api/ticket")
@CrossOrigin("*")
public class TicketRestController {

    @Autowired
    private ITicketService iTicketService;

    //ThanhNT
    @PutMapping("/update-ticket/{id}")
    public ResponseEntity<Ticket> updateStatusTicket(@PathVariable int id) {
        Optional<Ticket> ticket = iTicketService.findById(id);
        if (ticket.isPresent()) {
            iTicketService.updateTicketById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @RequestMapping(value = "/list-ticket/{id}", method = RequestMethod.GET)
    public ResponseEntity<Optional<ITicketDto>> showInformationTicket(@PathVariable Integer id) {
        Optional<ITicketDto> ticketDto = iTicketService.findInfoTicketById(id);
        if (!ticketDto.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(ticketDto, HttpStatus.OK);
    }

    //HungB
    @GetMapping("/list")
    public ResponseEntity<Page<ITicketManagerDto>> findAllTicket(
            @RequestParam(value = "ticketId", defaultValue = "") Integer ticketId,
            @RequestParam(value = "customerId", defaultValue = "") Integer customerId,
            @RequestParam(value = "idCard", defaultValue = "") String idCard,
            @RequestParam(value = "phoneNumber", defaultValue = "") String phoneNumber,
            Pageable pageable) {
        Page<ITicketManagerDto> blogList = this.iTicketService.findAllByQuery(
                ticketId,
                customerId,
                idCard,
                phoneNumber,
                pageable
        );
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(blogList, HttpStatus.OK);
        }
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> findTicketById(@RequestBody TicketDto ticketDto,
                                            @PathVariable Integer id,
                                            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldError(),
                    HttpStatus.BAD_REQUEST);
        }
        Ticket ticket = new Ticket();
        ticket.setId(id);
        BeanUtils.copyProperties(ticketDto, ticket);
        iTicketService.saveTicket(ticket);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
