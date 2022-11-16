//package projectbackend.controller;
//
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.*;
//import projectbackend.dto.ticket.ITicketDto;
//import projectbackend.dto.ticket.TicketDto;
//import projectbackend.model.ticket.Ticket;
//import projectbackend.service.ticket.ITicketService;
//import org.springframework.web.bind.annotation.RestController;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.web.PageableDefault;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import projectbackend.dto.ticket.ITicketDto;
//import projectbackend.model.room.SeatType;
//import projectbackend.model.ticket.Ticket;
//import projectbackend.service.ticket.ITicketService;
//
//import java.util.Optional;
//
//@CrossOrigin("*")
//@RestController
//@RequestMapping("/api/ticket")
//public class TicketRestController {
//<<<<<<< HEAD
//
//    @Autowired
//    private ITicketService iTicketService;
//
//    @GetMapping("/ticket/list")
//    public ResponseEntity<Page<ITicketDto>> findAllTicket(
//            @RequestParam(value = "ticketId", defaultValue = "") Integer ticketId,
//            @RequestParam(value = "customerId", defaultValue = "") Integer customerId,
//            @RequestParam(value = "idCard", defaultValue = "") String idCard,
//            @RequestParam(value = "phoneNumber", defaultValue = "") String phoneNumber,
//            Pageable pageable) {
//        Page<ITicketDto> blogList = this.iTicketService.findAllByQuery(
//                ticketId,
//                customerId,
//                idCard,
//                phoneNumber,
//                pageable
//        );
//        if (blogList.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } else {
//            return new ResponseEntity<>(blogList, HttpStatus.OK);
//        }
//    }
//
//    @PatchMapping("/ticket/edit/{id}")
//    public ResponseEntity<?> findTicketById(@RequestBody TicketDto ticketDto,
//                                            @PathVariable Integer id,
//                                            BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            return new ResponseEntity<>(bindingResult.getFieldError(),
//                    HttpStatus.BAD_REQUEST);
//        }
//        Ticket ticket = new Ticket();
//        ticket.setId(id);
//        BeanUtils.copyProperties(ticketDto, ticket);
//        iTicketService.saveTicket(ticket);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//
//=======
//    @Autowired
//    ITicketService iTicketService;
//
//    @GetMapping("/booking/ticket")
//    public ResponseEntity<Page<ITicketDto>> showListBookingTicket(@PageableDefault(value = 5) Pageable pageable) {
//        Page<ITicketDto> ticketPage = iTicketService.findAllBookingTickets(pageable, "abristog");
//        if (ticketPage.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(ticketPage, HttpStatus.OK);
//    }
//
//    @GetMapping("/canceled/ticket")
//    public ResponseEntity<Page<ITicketDto>> showListCanceledTicket(@PageableDefault(value = 5) Pageable pageable) {
//        Page<ITicketDto> ticketPage = iTicketService.findAllCanceledTickets(pageable, "admin");
//        if (ticketPage.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(ticketPage, HttpStatus.OK);
//    }
//
//
//    @GetMapping("/history/point")
//    public ResponseEntity<Page<ITicketDto>> showListHistoryPoint(
//            @PageableDefault(value = 5) Pageable pageable,
//            @RequestParam(value = "bookingTime", defaultValue = "", required = false) String bookingTime,
//            @RequestParam(value = "price", defaultValue = "0") int value) {
//
//        Page<ITicketDto> historyPointSearch;
//        if (value == 0) {
//            historyPointSearch = iTicketService.findAllHistoryPoint("abristog", bookingTime, pageable);
//        } else {
//            historyPointSearch = iTicketService.findAllHistoryPointSearch("abristog", bookingTime, value, pageable);
//        }
//
//        if (historyPointSearch.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(historyPointSearch, HttpStatus.OK);
//
//    }
//
//    @DeleteMapping("delete/ticket/{id}")
//    public ResponseEntity<Ticket> deleteTicket(@PathVariable Integer id) {
//        Optional<Ticket> ticket = iTicketService.findByIdTicKet(id);
//        System.out.println(iTicketService.findByIdTicKet(id).get());
//        if (ticket.isPresent()) {
//            iTicketService.deleteTicket(id);
//            return new ResponseEntity<>(HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//>>>>>>> 64d10b2d9de9139a708810c54b62b43d556033c6
//}
//
