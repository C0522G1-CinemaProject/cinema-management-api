package projectbackend.controller;


import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projectbackend.dto.movie.IMovieDto;
import projectbackend.service.movie.IMovieService;

import projectbackend.model.movie.Movie;
import org.springframework.validation.FieldError;
import javax.validation.Valid;
import java.util.List;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/movie")
public class MovieRestController {
    @Autowired
    private IMovieService iMovieService;

    @GetMapping(value = "/detail/{id}")
    public ResponseEntity<Optional<IMovieDto>> getMovieDetail(@PathVariable Integer id) {
        Optional<IMovieDto> movie = iMovieService.movieDetail(id);
        if (!movie.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }


    @GetMapping("/list/home")
    public ResponseEntity<Page<IMovieDto>> getAllMovie(@RequestParam(value = "name", defaultValue = "") String name,
                                                   @PageableDefault(value = 5) Pageable pageable) {
        Page<IMovieDto> moviePage = movieService.findAllMovie(name, pageable);
        if (moviePage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(moviePage, HttpStatus.OK);
    }


    @GetMapping(value = "/list")
    public ResponseEntity<Page<IMovieDto>> getList(Pageable pageable,@RequestParam(value = "name",defaultValue = "") String name) {
        Page<IMovieDto> movieList = movieService.findAllMovie(pageable, name);
        if (movieList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(movieList, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Movie> deleteMovie(@PathVariable int id) {
        Optional<Movie> movie = movieService.findById(id);
        if (movie.isPresent()) {
            movieService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

 
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

