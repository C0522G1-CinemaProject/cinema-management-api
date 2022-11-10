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

    @GetMapping("/booking/ticket/{username}")
    public ResponseEntity<Page<ITicketDto>> showListBookingTicket(@PathVariable String username,
                                                                  @PageableDefault(value = 5) Pageable pageable) {
        Page<ITicketDto> ticketPage = iTicketService.findAllBookingTickets(pageable, username);
        if (ticketPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(ticketPage, HttpStatus.OK);
    }

    @GetMapping("/canceled/ticket/{username}")
    public ResponseEntity<Page<ITicketDto>> showListCanceledTicket(@PathVariable String username,
                                                                   @PageableDefault(value = 5) Pageable pageable) {
        Page<ITicketDto> ticketPage = iTicketService.findAllCanceledTickets(pageable, username);
        if (ticketPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(ticketPage, HttpStatus.OK);
    }


    @GetMapping("/history/point/{username}")
    public ResponseEntity<Page<ITicketDto>> showListHistoryPoint(
            @PathVariable String username,
            @PageableDefault(value = 5) Pageable pageable,
            @RequestParam(value = "booKingTime", defaultValue = "") String bookingTime,
            @RequestParam(value = "price", defaultValue = "0") int price) {

        Page<ITicketDto> historyPointSearch ;
        if(price ==0){
            historyPointSearch = iTicketService.findAllHistoryPointSearch(username, bookingTime, pageable);
        }
        else{
            historyPointSearch = iTicketService.findAllHistoryPoint(username, bookingTime, price, pageable);
        }

        if (historyPointSearch.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(historyPointSearch, HttpStatus.OK);

    }

}
