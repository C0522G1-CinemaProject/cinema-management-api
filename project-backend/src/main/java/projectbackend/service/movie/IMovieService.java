package projectbackend.service.movie;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import projectbackend.dto.movie.IMovieDto;
import projectbackend.model.movie.Movie;

public interface IMovieService {

    Page<IMovieDto> findAllMovie(String name, Pageable pageable);
}
