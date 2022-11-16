package projectbackend.service.movie;

import projectbackend.model.movie.Movie;

import java.util.List;

public interface IMovieService {
    List<Movie> findAll();
}
