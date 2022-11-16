package projectbackend.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import projectbackend.dto.ticket.ITicketDto;
import projectbackend.dto.ticket.TicketDto;
import projectbackend.model.ticket.Ticket;
import projectbackend.service.decentralization.impl.MyUserDetails;
import projectbackend.service.ticket.ITicketService;

import java.util.List;
import java.util.Optional;

@RequestMapping("api/ticket")
@RestController
@CrossOrigin("*")
public class TicketRestController {

    @Autowired
    private ITicketService iTicketService;

    @GetMapping("/findCustomerName/and/point")
    public ResponseEntity<?> findByCustomerNameAndPoint() {
        String username = ((MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        System.out.println(username);
        Optional<ITicketDto> ticketPage = iTicketService.findByCustomerNameAndPoint(username);
        if (ticketPage.isPresent()) {
            return new ResponseEntity<>(ticketPage, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }


    @GetMapping("/booking")
    public ResponseEntity<Page<ITicketDto>> showListBookingTicket(Pageable pageable) {
        String username = ((MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        Page<ITicketDto> ticketPage = iTicketService.findAllBookingTickets(pageable, username);
        if (ticketPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(ticketPage, HttpStatus.OK);
    }

    @GetMapping("/canceled")
    public ResponseEntity<Page<ITicketDto>> showListCanceledTicket(@PageableDefault(value = 5) Pageable pageable) {
        String username = ((MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        Page<ITicketDto> ticketPage = iTicketService.findAllCanceledTickets(pageable, username);
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
        String username = ((MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        Page<ITicketDto> historyPointSearch = iTicketService.findAllHistoryPoint(username, startTime, endTime, pageable);

        if (historyPointSearch.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(historyPointSearch, HttpStatus.OK);
    }

    @GetMapping("/history/plusPoint")
    public ResponseEntity<Page<ITicketDto>> showTheListOfPointsAdded(
            Pageable pageable,
            @RequestParam(value = "startTime", defaultValue = "0000-00-00", required = false) String startTime,
            @RequestParam(value = "endTime", defaultValue = "3000-00-00", required = false) String endTime) {
        String username = ((MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        Page<ITicketDto> historyPigPointSearch = iTicketService.findAllBigPoint(username, startTime, endTime, pageable);

        if (historyPigPointSearch.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(historyPigPointSearch, HttpStatus.OK);
    }

    @GetMapping("/history/usedPoint")
    public ResponseEntity<Page<ITicketDto>> showListOfUsePoints(
            Pageable pageable,
            @RequestParam(value = "startTime", defaultValue = "0000-00-00", required = false) String startTime,
            @RequestParam(value = "endTime", defaultValue = "3000-11-04", required = false) String endTime) {

        String username = ((MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        Page<ITicketDto> historySmallPointSearch = iTicketService.findAllSmallPoint
                (username, startTime, endTime, pageable);

        if (historySmallPointSearch.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(historySmallPointSearch, HttpStatus.OK);
    }


    @DeleteMapping("delete/{id}")
    public ResponseEntity<Ticket> deleteTicket(@PathVariable Integer id) {
        Optional<Ticket> ticket = iTicketService.findTicketById(id);
        if (ticket.isPresent()) {
            iTicketService.deleteTicket(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


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

