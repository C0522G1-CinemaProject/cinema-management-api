package projectbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projectbackend.dto.movie.IMovieDto;
import projectbackend.model.movie.Movie;
import projectbackend.service.movie.IMovieService;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/movie/")
public class MovieRestController {
    @Autowired
    private IMovieService movieService;

    @GetMapping(value = "list")
    public ResponseEntity<Page<IMovieDto>> getList(Pageable pageable,@RequestParam(value = "name",defaultValue = "") String name) {
        Page<IMovieDto> movieList = movieService.findAllMovie(pageable, name);
        if (movieList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(movieList, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Movie> deleteMovie(@PathVariable int id) {
        Optional<Movie> movie = movieService.findById(id);
        if (movie.isPresent()) {
            movieService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

