package projectbackend.service.movie.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import projectbackend.dto.movie.IMovieStatementDto;
import projectbackend.repository.movie.IMovieRepository;
import projectbackend.service.movie.IMovieService;

import java.util.List;

@Service
public class MovieService implements IMovieService {

    @Autowired
    private IMovieRepository movieRepository;

    /**
     * creator: Phan Phước Đại
     * method use statistical top movie positive
     * */
    @Override
    public Page<IMovieStatementDto> getMovieTop(Pageable pageable) {
        return movieRepository.getMovieTop(pageable);
    }

    /**
     * creator: Phan Phước Đại
     * method use statistical top movie positive
     * */
    @Override
    public List<IMovieStatementDto> getMovieTop() {
        return movieRepository.getMovieTop();
    }

    /**
     * creator: Phan Phước Đại
     * method use statistical top movie positive
     * */
    @Override
    public List<IMovieStatementDto> getMovieTop(int numberMonth) {
        if (numberMonth == 0) {
            return movieRepository.getMovieTop();
        }
        return movieRepository.getMovieTop(numberMonth);
    }
}
