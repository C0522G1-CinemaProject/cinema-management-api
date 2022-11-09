package projectbackend.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projectbackend.dto.movie.MovieDto;
import projectbackend.dto.show_times.ShowTimesDto;
import projectbackend.model.movie.Movie;
import projectbackend.model.show_times.ShowTimes;
import projectbackend.repository.show_times.IShowTimesRepository;
import projectbackend.service.show_times.IShowTimesService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/showTime")
public class ShowTimesRestController {

    @Autowired
    private IShowTimesService showTimesService;

    @GetMapping("")
    public ResponseEntity<List<ShowTimes>> getListShowTime() {
        List<ShowTimes> showTimes = showTimesService.getListShowTime();

        if (showTimes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(showTimes, HttpStatus.OK);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<ShowTimes> addShowTime(@RequestBody MovieDto movieDto) {
        ShowTimes showTimes = new ShowTimes();
        BeanUtils.copyProperties(movieDto, showTimes);
        showTimesService.addShowTime(showTimes);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/edit/{id}")
    public ResponseEntity<Movie> editMovie(@RequestBody MovieDto movieDto,
                                           @PathVariable Integer id) {
        ShowTimes showTimes = showTimesService.findById(id).get();
        BeanUtils.copyProperties(movieDto, showTimes);
        showTimesService.editShowTime(showTimes);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
