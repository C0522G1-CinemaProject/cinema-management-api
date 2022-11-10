package projectbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projectbackend.dto.movie.IMovieDto;
import projectbackend.service.movie.IMovieService;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/movie")
public class MovieRestController {
    @Autowired
    private IMovieService iMovieService;

    @GetMapping(value = "/detail/{id}")
    public ResponseEntity<Optional<IMovieDto>> getMovieDetail(@PathVariable Integer id) {
        Optional<IMovieDto> movie = iMovieService.movieDetail(id);
        if (!movie.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }


}
