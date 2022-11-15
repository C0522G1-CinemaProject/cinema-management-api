package projectbackend.controller;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projectbackend.dto.customer.CustomerDto;
import projectbackend.dto.ticket.ITicketDto;
import projectbackend.model.customer.Customer;
import projectbackend.model.ticket.Ticket;
import projectbackend.service.ticket.ITicketService;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RequestMapping("api")
@RestController
public class TicketRestController {
    @Autowired
    ITicketService iTicketService;

    @GetMapping("/booking/ticket")
    public ResponseEntity<Page<ITicketDto>> showListBookingTicket(Pageable pageable) {
        Page<ITicketDto> ticketPage = iTicketService.findAllBookingTickets(pageable, "admin");
        if (ticketPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(ticketPage, HttpStatus.OK);
    }


    @GetMapping("/point")
    public ResponseEntity<List<ITicketDto>> showListTotalPoint() {
        List<ITicketDto> totalPoint = iTicketService.totalPoint("admin");
        if (totalPoint.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(totalPoint, HttpStatus.OK);
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
            Pageable pageable,
            @RequestParam(value = "startTime", defaultValue = "0000-00-00", required = false) String startTime,
            @RequestParam(value = "endTime", defaultValue = "3000-11-04", required = false) String endTime) {

        Page<ITicketDto> historyPointSearch = iTicketService.findAllHistoryPoint("abristog", startTime, endTime, pageable);

        if (historyPointSearch.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(historyPointSearch, HttpStatus.OK);
    }

    @GetMapping("/history/bigPoint")
    public ResponseEntity<Page<ITicketDto>> showListBigPoint(
            Pageable pageable,
            @RequestParam(value = "startTime", defaultValue = "0000-00-00", required = false) String startTime,
            @RequestParam(value = "endTime", defaultValue = "3000-00-00", required = false) String endTime) {

        Page<ITicketDto> historyPigPointSearch = iTicketService.findAllBigPoint("abristog", startTime, endTime, pageable);

        if (historyPigPointSearch.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(historyPigPointSearch, HttpStatus.OK);
    }

    @GetMapping("/history/smallPoint")
    public ResponseEntity<Page<ITicketDto>> showListSmallPoint(
            Pageable pageable,
            @RequestParam(value = "startTime", defaultValue = "0000-00-00", required = false) String startTime,
            @RequestParam(value = "endTime", defaultValue = "3000-11-04", required = false) String endTime) {

        Page<ITicketDto> historySmallPointSearch = iTicketService.findAllSmallPoint
                ("abristog", startTime, endTime, pageable);

        if (historySmallPointSearch.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(historySmallPointSearch, HttpStatus.OK);
    }


    @DeleteMapping("delete/ticket/{id}")
    public ResponseEntity<Ticket> deleteTicket(@PathVariable Integer id) {
        Optional<Ticket> ticket = iTicketService.findByIdTicKet(id);
        if (ticket.isPresent()) {
            iTicketService.deleteTicket(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
}

