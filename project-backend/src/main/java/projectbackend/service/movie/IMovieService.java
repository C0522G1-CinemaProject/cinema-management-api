package projectbackend.service.movie;

import projectbackend.dto.movie.IMovieDto;


import java.util.Optional;

public interface IMovieService {
    Optional<IMovieDto> movieDetail(Integer id);


}
