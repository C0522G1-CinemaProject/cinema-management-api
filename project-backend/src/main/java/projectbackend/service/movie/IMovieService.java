package projectbackend.service.movie;

import projectbackend.dto.movie.IMovieStatementDto;

import java.util.List;

public interface IMovieService {

    List<IMovieStatementDto> getMovieTop(int numberMonth);
}
