package projectbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projectbackend.model.movie.Movie;
import projectbackend.service.movie.IMovieService;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("movie/")
public class MovieRestController {
    @Autowired
    private IMovieService iMovieService;

    @GetMapping(value = "list")
    public ResponseEntity<Page<Movie>> getList(Pageable pageable, String keyword) {
        Page<Movie> movieList = iMovieService.findAllMovie(pageable, keyword);
        if (movieList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(movieList, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Movie> deleteMovie(@PathVariable int id) {
        Optional<Movie> movie = iMovieService.findById(id);
        if (movie.isPresent()) {
            iMovieService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

