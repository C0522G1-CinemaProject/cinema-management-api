package projectbackend.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import projectbackend.dto.ticket.ITicketDto;
import projectbackend.dto.ticket.TicketDto;
import projectbackend.model.ticket.Ticket;
import projectbackend.service.ticket.ITicketService;

@RestController
@RequestMapping("/api/v3")
@CrossOrigin("*")
public class TicketRestController {

    @Autowired
    private ITicketService iTicketService;

    @GetMapping("/ticket/list")
    public ResponseEntity<Page<ITicketDto>> findAllTicket(
            @RequestParam(value = "ticketId", defaultValue = "") Integer ticketId,
            @RequestParam(value = "customerId", defaultValue = "") Integer customerId,
            @RequestParam(value = "idCard", defaultValue = "") String idCard,
            @RequestParam(value = "phoneNumber", defaultValue = "") String phoneNumber,
            Pageable pageable) {
        Page<ITicketDto> blogList = this.iTicketService.findAllByQuery(
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

    @PatchMapping("/ticket/edit/{id}")
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
