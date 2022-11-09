package projectbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projectbackend.dto.booking_ticket.IMovie;
import projectbackend.dto.booking_ticket.ISeatDetail;
import projectbackend.dto.booking_ticket.IShowDates;
import projectbackend.dto.booking_ticket.IShowTimes;
import projectbackend.service.show_times.IShowTimesService;
import projectbackend.service.ticket.ISeatDetailService;

import java.util.List;

@RestController
@RequestMapping("/api/booking-ticket")
@CrossOrigin("*")
public class TicketRestController {
    @Autowired
    private IShowTimesService showTimesService;

    @Autowired
    private ISeatDetailService seatDetailService;

    @GetMapping("/movie")
    public ResponseEntity<List<IMovie>> showMovieIn7NextDay() {
        List<IMovie> movies = showTimesService.findAllMovie();

        if (movies.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping("/show-date/{idMovie}")
    public ResponseEntity<List<IShowDates>> showDateByMovie(@PathVariable Integer idMovie) {
        List<IShowDates> showDates = showTimesService.findAllShowDate(idMovie);

        if (showDates.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(showDates, HttpStatus.OK);
    }

    @GetMapping("/showtime/{showDate}")
    public ResponseEntity<List<IShowTimes>> showTimeByShowDate(@PathVariable String showDate) {
        List<IShowTimes> showTimes = showTimesService.findAllShowTimesInDay(showDate);

        if (showTimes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(showTimes, HttpStatus.OK);
    }

    @GetMapping("/seat-detail/{idShowTime}/{idRoom}")
    public ResponseEntity<List<ISeatDetail>> showAllSeatDetail(@PathVariable Integer idShowTime, Integer idRoom) {
        List<ISeatDetail> seatDetails = seatDetailService.findAllSeatDetail(idShowTime, idRoom);

        if (seatDetails.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(seatDetails, HttpStatus.OK);
    }
}
