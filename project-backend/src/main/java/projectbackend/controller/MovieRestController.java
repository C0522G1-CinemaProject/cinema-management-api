package projectbackend.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projectbackend.dto.movie.IMovieDto;
import projectbackend.dto.movie.MovieDto;
import projectbackend.model.movie.Movie;
import projectbackend.service.movie.IMovieService;

@CrossOrigin
@RestController
@RequestMapping("/movie")
public class MovieRestController {

    @Autowired
    private IMovieService movieService;

    @GetMapping("/{id}")
    public ResponseEntity<IMovieDto> getMovie(@PathVariable int id) {
        IMovieDto iMovieDto = movieService.getMovie(id);
        return new ResponseEntity<>(iMovieDto, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Movie> addMovie(@RequestBody MovieDto movieDto) {
        Movie movie = new Movie();
        BeanUtils.copyProperties(movieDto, movie);
        movieService.addMovie(movie);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/edit/{id}")
    public ResponseEntity<Movie> editMovie(@RequestBody MovieDto movieDto,
                                           @PathVariable Integer id) {
        Movie movie = movieService.finById(id).get();
        BeanUtils.copyProperties(movieDto, movie);
        movieService.editMovie(movie);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
