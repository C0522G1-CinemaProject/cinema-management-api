package projectbackend.service.show_times;

import projectbackend.model.show_times.Times;

import java.util.List;

public interface ITimesService {
    List<Times> findAll();
}
