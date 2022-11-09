package projectbackend.service.movie.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projectbackend.model.movie.Movie;
import projectbackend.repository.movie.IMovieRepository;
import projectbackend.service.movie.IMovieService;

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
}
