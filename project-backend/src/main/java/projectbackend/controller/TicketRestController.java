package projectbackend.controller;


import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projectbackend.dto.ticket.ITicketDto;
import projectbackend.dto.ticket.TicketDto;
import projectbackend.model.room.SeatType;
import projectbackend.model.ticket.Ticket;
import projectbackend.service.ticket.ITicketService;

import java.util.Optional;

@CrossOrigin("*")
@RequestMapping("api")
@RestController
public class TicketRestController {
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
            @RequestParam(value = "point", defaultValue = "0") int value) {

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

    @GetMapping("/history/bigPoint")
    public ResponseEntity<Page<ITicketDto>> showListBigPoint(
            @PageableDefault(value = 5) Pageable pageable,
            @RequestParam(value = "bookingTime", defaultValue = "", required = false) String bookingTime) {

        Page<ITicketDto> historyPigPointSearch = iTicketService.findAllBigPoint("abristog", bookingTime, pageable);

        if (historyPigPointSearch.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(historyPigPointSearch, HttpStatus.OK);
    }

    @GetMapping("/history/smallPoint")
    public ResponseEntity<Page<ITicketDto>> showListSmallPoint(
            @PageableDefault(value = 5) Pageable pageable,
            @RequestParam(value = "bookingTime", defaultValue = "", required = false) String bookingTime) {

        Page<ITicketDto> historySmallPointSearch = iTicketService.findAllSmallPoint("abristog", bookingTime, pageable);

        if (historySmallPointSearch.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(historySmallPointSearch, HttpStatus.OK);
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

