package projectbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projectbackend.dto.movie.ITimeDto;
import projectbackend.model.show_times.ShowTimes;
import projectbackend.service.show_times.IShowTimesService;
import projectbackend.service.show_times.ITimesService;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/showTime")
public class ShowTimesRestController {

    @Autowired
    private IShowTimesService showTimesService;

    @Autowired
    private ITimesService timesService;

    @GetMapping("/{id}")
    public ResponseEntity<List<ShowTimes>> getListShowTime(@PathVariable Integer id) {
        List<ShowTimes> showTimes = showTimesService.getShowTime(id);

        if (showTimes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(showTimes, HttpStatus.OK);
        }
    }



  /*  @PatchMapping("/edit/{id}")
    public ResponseEntity<Movie> editMovie(@RequestBody ShowTimesDto showTimesDto,
                                           @PathVariable Integer id) {
        ShowTimes showTimes = showTimesService.findById(id).get();
        BeanUtils.copyProperties(showTimesDto, showTimes);
        showTimesService.editShowTime(showTimes);
        return new ResponseEntity<>(HttpStatus.OK);
    }
*/
    @GetMapping("/time")
    public ResponseEntity<List<ITimeDto>> getTime(@RequestParam(value = "dateT", defaultValue = "") String dateProjection,
                                                  @RequestParam(value = "idRoom", defaultValue = "") Integer room) {
        List<ITimeDto> times = timesService.getTime(dateProjection, room);
        return new ResponseEntity<>(times, HttpStatus.OK);
    }
}
