package projectbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projectbackend.dto.movie.IMovieDto;
import projectbackend.model.movie.Movie;
import projectbackend.service.movie.IMovieService;

@RestController
@RequestMapping("/movie")
@CrossOrigin("*")
public class MovieRestController {

    @Autowired
    private  IMovieService movieService;

    @GetMapping("/list")
    public ResponseEntity<Page<IMovieDto>> getAllMovie(@RequestParam(value = "name", defaultValue = "") String name,
                                                   @PageableDefault(value = 5) Pageable pageable) {
        Page<IMovieDto> moviePage = movieService.findAllMovie(name, pageable);
        if (moviePage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(moviePage, HttpStatus.OK);
    }
}
