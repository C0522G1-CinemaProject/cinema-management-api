package projectbackend.service.movie;

import projectbackend.dto.movie.IMovieStatementDto;

import java.util.List;

public interface IMovieService {
    /**
     * creator: Phan Phước Đại
     * date:11/11/2022
     * method use statistical top movie positive
     */
    List<IMovieStatementDto> getMovieTop(int numberMonth);
}
