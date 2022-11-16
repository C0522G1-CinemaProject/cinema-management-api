package projectbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projectbackend.dto.ticket.ITicketDto;
import projectbackend.dto.ticket.ITicketManagerDto;
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
    @GetMapping("/list-ticket-manager")
    public ResponseEntity<Page<ITicketManagerDto>> findAllTicket(
             Pageable pageable,
            @RequestParam(value = "ticketId", defaultValue = "") Integer ticketId,
            @RequestParam(value = "customerId", defaultValue = "") Integer customerId,
            @RequestParam(value = "idCard", defaultValue = "") String idCard,
            @RequestParam(value = "phoneNumber", defaultValue = "") String phoneNumber
    ) {
        Page<ITicketManagerDto> iTicketManagerDtos = this.iTicketService.findAllByQuery(
                pageable,
                ticketId,
                customerId,
                idCard,
                phoneNumber
        );
        if (iTicketManagerDtos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(iTicketManagerDtos, HttpStatus.OK);
        }
    }
    @PatchMapping("/edit-ticket-by/{id}")
    public ResponseEntity<Optional<ITicketManagerDto>> editTicketManagerDto(@PathVariable Integer id) {
        Optional<ITicketManagerDto> ticket = iTicketService.findTicketManagerById(id);
        if (ticket.isPresent()) {
            iTicketService.editTicketManager(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/find-ticket-by/{id}")
    public ResponseEntity<Optional<ITicketManagerDto>> findTicketManagerDtoById(@PathVariable Integer id) {
        Optional<ITicketManagerDto> ticketManagerDto = iTicketService.findTicketManagerById(id);
        if (!ticketManagerDto.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(ticketManagerDto, HttpStatus.OK);
    }

}
