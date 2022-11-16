package projectbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projectbackend.dto.ticket.ITicketDto;
import projectbackend.model.ticket.Ticket;
import projectbackend.service.ticket.ITicketService;

import java.util.Optional;

@RestController
@RequestMapping("/api/ticket")
@CrossOrigin("*")
public class TicketRestController {

    @Autowired
    private ITicketService iTicketService;

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


    @GetMapping(value = "/list-ticket/{id}")
    public ResponseEntity<Optional<ITicketDto>> showInformationTicket(@PathVariable Integer id) {
        Optional<ITicketDto> ticketDto = iTicketService.findTicketById(id);
        if (!ticketDto.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(ticketDto, HttpStatus.OK);
    }
}
