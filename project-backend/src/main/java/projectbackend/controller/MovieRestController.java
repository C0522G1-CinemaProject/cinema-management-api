package projectbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projectbackend.dto.customer.ICustomerStatementDto;
import projectbackend.dto.movie.IMovieStatementDto;
import projectbackend.service.movie.IMovieService;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/movie")
@CrossOrigin("*")
public class MovieRestController {

    @Autowired
    private IMovieService movieService;

    @GetMapping("/statement")
    public ResponseEntity<List<IMovieStatementDto>> getCustomerTop(@RequestParam(defaultValue = "0") int numberMonth) {
        if(numberMonth<0){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<IMovieStatementDto> customerStatementDtoPage = movieService.getMovieTop(numberMonth);
        if (customerStatementDtoPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customerStatementDtoPage, HttpStatus.OK);
    }
}
