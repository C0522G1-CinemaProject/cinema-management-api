package projectbackend.service.movie;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import projectbackend.model.movie.Movie;

import java.util.Optional;

public interface IMovieService {
    Page<Movie> findAllMovie(Pageable pageable, String keyword);

    void deleteById(int idDelete);

    Optional<Movie> findById(int id);
}
