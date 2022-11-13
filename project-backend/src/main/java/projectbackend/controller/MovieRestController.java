package projectbackend.controller;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import projectbackend.dto.movie.IMovieDto;
import projectbackend.dto.movie.IMovieDtoHome;
import projectbackend.dto.movie.MovieDto;
import projectbackend.model.movie.Movie;
import projectbackend.service.movie.IMovieService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin("*")
@RequestMapping("/api/movie")
public class MovieRestController {
    @Autowired
    private IMovieService iMovieService;

    //TruongNT function
    @GetMapping(value = "/detail/{id}")
    public ResponseEntity<Optional<IMovieDto>> getMovieDetail(@PathVariable Integer id) {
        Optional<IMovieDto> movie = iMovieService.getMovieDetail(id);
        if (!movie.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    //NamHV function
    //6.5.1.1. Danh Sách Phim – Xem danh sách phim
    //6.5.1.3. Danh sách Phim – Tìm kiếm Phim
    @GetMapping("/list/home")
    public ResponseEntity<Page<IMovieDtoHome>> getAllMovie(@RequestParam(value = "name", defaultValue = "") String name,
                                                       @PageableDefault(value = 5) Pageable pageable) {
        Page<IMovieDtoHome> moviePage = iMovieService.findAllHome(name, pageable);
        if (moviePage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(moviePage, HttpStatus.OK);
    }

    @GetMapping("/list/premiere")
    public ResponseEntity<Page<IMovieDtoHome>> getAllPremiereSoonMovie(@RequestParam(value = "name", defaultValue = "") String name,
                                                           @PageableDefault(value = 5) Pageable pageable) {
        Page<IMovieDtoHome> moviePage = iMovieService.findAllPremiereSoon(name, pageable);
        if (moviePage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(moviePage, HttpStatus.OK);
    }


    //TriHM function
    @GetMapping(value = "/list")
    public ResponseEntity<Page<IMovieDto>> getList(Pageable pageable, @RequestParam(value = "name", defaultValue = "") String name) {
        Page<IMovieDto> movieList = iMovieService.findAllMovie(pageable, name);
        if (movieList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(movieList, HttpStatus.OK);
    }

    //TriHM function
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Movie> deleteMovie(@PathVariable Integer id) {
        Optional<Movie> movie = iMovieService.finById(id);
        if (movie.isPresent()) {
            iMovieService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


//QuyetND function
    @GetMapping("/{id}")
    public ResponseEntity<IMovieDto> getMovie(@PathVariable int id) {
        IMovieDto iMovieDto = iMovieService.getMovie(id);
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
        iMovieService.addMovie(movie);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //QuyetND function
    @PatchMapping("/edit/{id}")
    public ResponseEntity<List<FieldError>> editMovie(@RequestBody @Valid MovieDto movieDto,
                                                      BindingResult bindingResult,
                                                      @PathVariable Integer id) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(),
                    HttpStatus.BAD_REQUEST);
        }
        Movie movie = iMovieService.finById(id).get();
        BeanUtils.copyProperties(movieDto, movie);
        iMovieService.editMovie(movie);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

