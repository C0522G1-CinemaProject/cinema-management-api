package projectbackend.service.movie.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projectbackend.dto.movie.IMovieDto;
import projectbackend.dto.movie.ITimeDto;
import projectbackend.model.movie.Movie;
import projectbackend.model.show_times.Times;
import projectbackend.repository.movie.IMovieRepository;
import projectbackend.service.movie.IMovieService;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService implements IMovieService {

    @Autowired
    private IMovieRepository movieRepository;

    @Override
    public void addMovie(Movie movie) {
        movieRepository.save(movie);
    }

    @Override
    public void editMovie(Movie movie) {
        movieRepository.save(movie);
    }

    @Override
    public IMovieDto getMovie(Integer id) {
        return movieRepository.findMovieById(id);
    }

    @Override
    public Optional<Movie> finById(Integer id) {
        return movieRepository.findById(id);
    }
}
