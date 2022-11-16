package projectbackend.service.show_times.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projectbackend.dto.movie.IShowTimeDto;
import projectbackend.model.show_times.ShowTimes;
import projectbackend.repository.show_times.IShowTimesRepository;
import projectbackend.service.show_times.IShowTimesService;

import java.util.List;
import java.util.Optional;

@Service
public class ShowTimesService implements IShowTimesService {

    @Autowired
    private IShowTimesRepository showTimesRepository;

    @Override
    public List<ShowTimes> getShowTime(Integer id) {
        return showTimesRepository.getShowTime(id);
    }

    @Override
    public void addShowTime(ShowTimes showTimes) {
        showTimesRepository.save(showTimes);
    }

    @Override
    public void editShowTime(ShowTimes showTimes) {
        showTimesRepository.save(showTimes);
    }

    @Override
    public Optional<ShowTimes> findById(Integer id) {
        return showTimesRepository.findById(id);
    }
}
