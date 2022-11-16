package projectbackend.service.movie;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import projectbackend.dto.movie.IMovieDto;
import projectbackend.dto.movie.MovieFullDto;
import projectbackend.model.movie.Movie;
import projectbackend.model.show_times.ShowTimes;

import java.util.List;
import java.util.Optional;

public interface IMovieService {
    Optional<IMovieDto> getMovieDetail(Integer id);


    Page<IMovieDto> findAllHome(String name, Pageable pageable);

    Page<IMovieDto> findAllMovie(Pageable pageable, String keyword);

    void deleteById(int idDelete);

    void addMovieDto(MovieFullDto movie);

    void editMovieDto(MovieFullDto movieFullDto);

    Movie getMovie(Integer id);

    List<ShowTimes> getShowTime(Integer id);

    Optional<Movie> finById(Integer id);

    List<Movie> getListMovie();
}
