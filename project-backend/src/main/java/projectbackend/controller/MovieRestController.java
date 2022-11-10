package projectbackend.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import projectbackend.dto.movie.IMovieDto;
import projectbackend.dto.movie.MovieDto;
import projectbackend.model.movie.Movie;
import projectbackend.service.movie.IMovieService;

import javax.validation.Valid;
import java.util.List;

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
    public ResponseEntity<List<FieldError>> addMovie(@RequestBody @Valid MovieDto movieDto,
                                                     BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(),
                    HttpStatus.BAD_REQUEST);
        }
        Movie movie = new Movie();
        BeanUtils.copyProperties(movieDto, movie);
        movieService.addMovie(movie);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/edit/{id}")
    public ResponseEntity<List<FieldError>> editMovie(@RequestBody @Valid MovieDto movieDto,
                                           BindingResult bindingResult,
                                           @PathVariable Integer id) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(),
                    HttpStatus.BAD_REQUEST);
        }
        Movie movie = movieService.finById(id).get();
        BeanUtils.copyProperties(movieDto, movie);
        movieService.editMovie(movie);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
