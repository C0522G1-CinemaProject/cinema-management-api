package projectbackend.service.movie;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import projectbackend.dto.movie.IMovieStatementDto;

public interface IMovieService {
    Page<IMovieStatementDto> getMovieTop(Pageable pageable);
}
