package projectbackend.service.movie;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import projectbackend.dto.movie.IMovieDto;
import projectbackend.model.movie.Movie;

import java.util.Optional;

public interface IMovieService {

    Page<IMovieDto> findAllMovie(Pageable pageable, String keyword);

    void deleteById(int idDelete);


    void addMovie(Movie movie);

    void editMovie(Movie movie);

    IMovieDto getMovie(Integer id);

    Optional<Movie> finById(Integer id);

}
