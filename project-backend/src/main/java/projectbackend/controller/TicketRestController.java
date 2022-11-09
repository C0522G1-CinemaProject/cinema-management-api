package projectbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/list")
    public ResponseEntity<Page<Ticket>> showAllTicket(@PageableDefault Pageable pageable) {
        Page<Ticket> ticket = iTicketService.findAllTicket(pageable);
        if (ticket.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ticket> updateTicket(@PathVariable int id) {
        Optional<Ticket> ticket = iTicketService.findById(id);
        if (ticket.isPresent()) {
            iTicketService.updateTicketById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/list-ticket/{id}")
    public ResponseEntity<Page<TicketDto>> showInformationTicket(@PageableDefault Pageable pageable, @PathVariable int id) {
        Page<TicketDto> ticketDto = iTicketService.findTicketById(pageable, id);
        if (ticketDto.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(ticketDto, HttpStatus.OK);
    }
}
