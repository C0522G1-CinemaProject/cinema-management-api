package projectbackend.service.show_times.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projectbackend.model.show_times.Times;
import projectbackend.repository.show_times.ITimesRepository;
import projectbackend.service.show_times.ITimesService;

import java.util.List;

@Service
public class TimesService implements ITimesService {
    @Autowired
    private ITimesRepository timesRepository;

    @Override
    public List<Times> findAll() {
        return timesRepository.findAll();
    }
}
