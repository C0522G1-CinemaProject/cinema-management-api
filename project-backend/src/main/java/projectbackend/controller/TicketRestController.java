package projectbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projectbackend.dto.ticket.ITicketDto;
import projectbackend.service.ticket.ITicketService;

@CrossOrigin("*")
@RequestMapping("api")
public class TicketRestController {
    @Autowired
    ITicketService iTicketService;

    @GetMapping("/booking/ticket/{id}")
    public ResponseEntity<Page<ITicketDto>> showListBookingTicket(@PathVariable Integer id,
                                                                  @PageableDefault(value = 5) Pageable pageable) {
        Page<ITicketDto> ticketPage = iTicketService.findAllBookingTickets(pageable, id);
        if (ticketPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(ticketPage, HttpStatus.OK);
    }

    @GetMapping("/canceled/ticket/{id}")
    public ResponseEntity<Page<ITicketDto>> showListCanceledTicket(@PathVariable Integer id,
                                                                   @PageableDefault(value = 5) Pageable pageable) {
        Page<ITicketDto> ticketPage = iTicketService.findAllCanceledTickets(pageable, id);
        if (ticketPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(ticketPage, HttpStatus.OK);
    }


    @GetMapping("/history/point/{id}")
    public ResponseEntity<Page<ITicketDto>> showListHistoryPoint(@PathVariable Integer id,
                                                                 @PageableDefault(value = 5) Pageable pageable,
                                                                 @RequestParam(value = "booKingTime", defaultValue = "") String bookingTime,
                                                                 @RequestParam(value = "price", defaultValue = "") int price) {
        Page<ITicketDto> ticketPage = iTicketService.findAllHistoryPoint(id, bookingTime, price, pageable);
        if (ticketPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(ticketPage, HttpStatus.OK);
    }

}
