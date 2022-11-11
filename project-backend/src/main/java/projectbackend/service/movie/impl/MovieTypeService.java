package projectbackend.service.movie.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projectbackend.model.movie.MovieType;
import projectbackend.repository.movie.IMovieTypeRepository;
import projectbackend.service.movie.IMovieTypeService;

import java.util.List;

@Service
public class MovieTypeService implements IMovieTypeService {

    @Autowired
    private IMovieTypeRepository movieTypeRepository;

    @Override
    public List<MovieType> getListMovieType() {
        return movieTypeRepository.findAll();
    }
}
