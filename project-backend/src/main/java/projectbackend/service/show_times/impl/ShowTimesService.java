package projectbackend.service.show_times.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projectbackend.model.show_times.ShowTimes;
import projectbackend.repository.show_times.IShowTimesRepository;
import projectbackend.service.show_times.IShowTimesService;

import java.util.List;

@Service
public class ShowTimesService implements IShowTimesService {

    @Autowired
    private IShowTimesRepository showTimesRepository;

    @Override
    public List<ShowTimes> getListShowTime() {
        return showTimesRepository.findAll();
    }

    @Override
    public void addShowTime(ShowTimes showTimes) {
        showTimesRepository.save(showTimes);
    }

    @Override
    public void editShowTime(ShowTimes showTimes) {
        showTimesRepository.save(showTimes);
    }
}
