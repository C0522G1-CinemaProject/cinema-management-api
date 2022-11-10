package projectbackend.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projectbackend.dto.movie.IShowTimeDto;
import projectbackend.dto.movie.ITimeDto;
import projectbackend.dto.movie.MovieDto;
import projectbackend.dto.show_times.ShowTimesDto;
import projectbackend.model.movie.Movie;
import projectbackend.model.show_times.ShowTimes;
import projectbackend.repository.show_times.IShowTimesRepository;
import projectbackend.service.show_times.IShowTimesService;
import projectbackend.service.show_times.ITimesService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/showTime")
public class ShowTimesRestController {

    @Autowired
    private IShowTimesService showTimesService;

    @Autowired
    private ITimesService timesService;

    @GetMapping("/{id}")
    public ResponseEntity<List<IShowTimeDto>> getListShowTime(@PathVariable Integer id) {
        List<IShowTimeDto> showTimeDtos = showTimesService.getShowTime(id);

        if (showTimeDtos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(showTimeDtos, HttpStatus.OK);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<ShowTimes> addShowTime(@RequestBody ShowTimesDto showTimesDto) {
        ShowTimes showTimes = new ShowTimes();
        BeanUtils.copyProperties(showTimesDto, showTimes);
        showTimesService.addShowTime(showTimes);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/edit/{id}")
    public ResponseEntity<Movie> editMovie(@RequestBody ShowTimesDto showTimesDto,
                                           @PathVariable Integer id) {
        ShowTimes showTimes = showTimesService.findById(id).get();
        BeanUtils.copyProperties(showTimesDto, showTimes);
        showTimesService.editShowTime(showTimes);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/time")
    public ResponseEntity<List<ITimeDto>> getTime(@RequestParam(defaultValue = "") String dateProjection,
                                                  @RequestParam(defaultValue = "") String room) {
        List<ITimeDto> times = timesService.getTime(dateProjection, room);
        return new ResponseEntity<>(times, HttpStatus.OK);
    }
}
