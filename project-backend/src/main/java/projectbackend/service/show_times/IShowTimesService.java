package projectbackend.service.show_times;

import projectbackend.dto.movie.IShowTimeDto;
import projectbackend.model.show_times.ShowTimes;

import java.util.List;
import java.util.Optional;

public interface IShowTimesService {

    List<ShowTimes> getShowTime(Integer id);

    void addShowTime(ShowTimes showTimes);

    void editShowTime(ShowTimes showTimes);

    Optional<ShowTimes> findById(Integer id);

}
