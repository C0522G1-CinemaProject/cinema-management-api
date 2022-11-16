package projectbackend.service.show_times;

import projectbackend.dto.booking_ticket.IMovie;
import projectbackend.dto.booking_ticket.IShowDates;
import projectbackend.dto.booking_ticket.IShowTimes;
import projectbackend.dto.movie.IShowTimeDto;
import projectbackend.model.show_times.ShowTimes;

import java.util.List;
import java.util.Optional;

public interface IShowTimesService {

    List<ShowTimes> getShowTime(Integer id);

    void addShowTime(ShowTimes showTimes);

    void editShowTime(ShowTimes showTimes);

    Optional<ShowTimes> findById(Integer id);

    List<ShowTimes> findAll();

    List<IMovie> findAllMovie();

    List<IShowDates> findAllShowDate(Integer idMovie);


}
