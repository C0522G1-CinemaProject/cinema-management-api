package projectbackend.service.movie;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import projectbackend.dto.movie.IMovieStatementDto;

import java.util.List;

public interface IMovieService {
    Page<IMovieStatementDto> getMovieTop(Pageable pageable);

    List<IMovieStatementDto> getMovieTop();
    List<IMovieStatementDto> getMovieTop(int numberMonth);
}
