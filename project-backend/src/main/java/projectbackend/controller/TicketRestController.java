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
    public ResponseEntity<Page<ITicketDto>> showListHistoryPoint(@PageableDefault(value = 5) Pageable pageable,
            @RequestParam(value = "bookingTime", defaultValue = "",required = false) String bookingTime,
            @RequestParam(value = "price", defaultValue = "0") int value) {

        Page<ITicketDto> historyPointSearch ;
        if(value ==0){
            historyPointSearch = iTicketService.findAllHistoryPoint("abristog", bookingTime, pageable);
        }
        else{
            historyPointSearch = iTicketService.findAllHistoryPointSearch("abristog", bookingTime, value, pageable);
        }

        if (historyPointSearch.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(historyPointSearch, HttpStatus.OK);

    }

}
