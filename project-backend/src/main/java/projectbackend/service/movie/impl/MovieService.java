package projectbackend.service.movie.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import projectbackend.dto.movie.IMovieDto;
import projectbackend.repository.movie.IMovieRepository;
import projectbackend.service.movie.IMovieService;

@Service
public class MovieService implements IMovieService {

    @Autowired
    IMovieRepository iMovieRepository;

    @Override
    public Page<IMovieDto> findAllMovie(String name, Pageable pageable) {
        return iMovieRepository.findAllMovie(name, pageable);
    }
}
