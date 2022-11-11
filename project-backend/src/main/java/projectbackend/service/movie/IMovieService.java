package projectbackend.service.movie;

import projectbackend.dto.movie.IMovieDto;
import projectbackend.model.movie.Movie;

import java.util.Optional;

public interface IMovieService {

    void addMovie(Movie movie);

    void editMovie(Movie movie);

    IMovieDto getMovie(Integer id);

    Optional<Movie> finById(Integer id);
}
