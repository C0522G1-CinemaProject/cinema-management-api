package projectbackend.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projectbackend.dto.booking_ticket.IMovie;
import projectbackend.dto.booking_ticket.ISeatDetail;
import projectbackend.dto.booking_ticket.IShowDates;
import projectbackend.dto.booking_ticket.IShowTimes;
import projectbackend.dto.ticket.TicketDto;
import projectbackend.jwt.JwtTokenUtil;
import projectbackend.model.customer.Customer;
import projectbackend.model.ticket.SeatDetail;
import projectbackend.model.ticket.Ticket;
import projectbackend.service.customer.ICustomerService;
import projectbackend.service.show_times.IShowTimesService;
import projectbackend.service.ticket.ISeatDetailService;
import projectbackend.service.ticket.ITicketService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/booking-ticket")
@CrossOrigin("*")
public class TicketRestController {
    @Autowired
    private IShowTimesService showTimesService;

    @Autowired
    private ISeatDetailService seatDetailService;

    @Autowired
    private ITicketService ticketService;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @GetMapping("/movie")
    public ResponseEntity<List<IMovie>> showMovieIn7NextDay() {
        List<IMovie> movies = showTimesService.findAllMovie();

        if (movies.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping("/show-date/{idMovie}")
    public ResponseEntity<List<IShowDates>> showDateByMovie(@PathVariable Integer idMovie) {
        List<IShowDates> showDates = showTimesService.findAllShowDate(idMovie);

        if (showDates.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(showDates, HttpStatus.OK);
    }

    @GetMapping("/showtime/{showDate}")
    public ResponseEntity<List<IShowTimes>> showTimeByShowDate(@PathVariable String showDate) {
        List<IShowTimes> showTimes = showTimesService.findAllShowTimesInDay(showDate);

        if (showTimes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(showTimes, HttpStatus.OK);
    }

    @GetMapping("/seat-detail/{idShowTime}")
    public ResponseEntity<List<ISeatDetail>> showAllSeatDetail(@PathVariable Integer idShowTime) {
        List<ISeatDetail> seatDetails = seatDetailService.findAllSeatDetail(idShowTime);

        if (seatDetails.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(seatDetails, HttpStatus.OK);
    }

    @PostMapping("/add-pending-ticket")
    public ResponseEntity<Ticket> addPendingTicket(@RequestBody TicketDto ticketDto) {
        Ticket ticket = new Ticket();
        BeanUtils.copyProperties(ticketDto, ticket);
        ticketService.saveTicket(ticket);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/get-customer")
    public ResponseEntity<Customer> getCustomerByUsername(HttpServletRequest request) {
        String headerAuth = request.getHeader("Authorization");

        String username = jwtTokenUtil.getUsernameFromJwtToken(headerAuth.substring(7));
        Customer customer = customerService.findByUsername(username);
        return  new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @GetMapping("/seat/{idSeatDetail}")
    public ResponseEntity<SeatDetail> getSeatDetailById(@PathVariable Integer idSeatDetail) {
        Optional<SeatDetail> seatDetail = seatDetailService.findById(idSeatDetail);
        return seatDetail.map(detail -> new ResponseEntity<>(detail, HttpStatus.OK)).orElseGet(()
                -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
