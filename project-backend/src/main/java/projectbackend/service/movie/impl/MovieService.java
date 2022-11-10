package projectbackend.service.movie.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projectbackend.dto.movie.IMovieDto;
import projectbackend.repository.movie.IMovieRepository;
import projectbackend.service.movie.IMovieService;

import java.util.Optional;

@Service
public class MovieService implements IMovieService {
    @Autowired
    private IMovieRepository iMovieRepository;

    @Override
    public Optional<IMovieDto> movieDetail(Integer id) {
        return iMovieRepository.movieDetail(id);
    }
}
