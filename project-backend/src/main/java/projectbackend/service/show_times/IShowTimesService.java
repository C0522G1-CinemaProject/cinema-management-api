package projectbackend.service.show_times;

import projectbackend.model.show_times.ShowTimes;

import java.util.List;

public interface IShowTimesService {

    List<ShowTimes> getListShowTime();

    void addShowTime(ShowTimes showTimes);

    void editShowTime(ShowTimes showTimes);
}
