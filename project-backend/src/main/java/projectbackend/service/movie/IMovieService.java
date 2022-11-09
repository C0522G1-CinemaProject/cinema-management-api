package projectbackend.service.movie;

import projectbackend.model.movie.Movie;

public interface IMovieService {

    void addMovie(Movie movie);

    void editMovie(Movie movie);
}
