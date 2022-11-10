package projectbackend.service.movie.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import projectbackend.dto.movie.IMovieDto;
import projectbackend.model.movie.Movie;
import projectbackend.repository.movie.IMovieRepository;
import projectbackend.service.movie.IMovieService;

import java.util.Optional;

@Service
public class MovieService implements IMovieService {

    @Autowired
    private IMovieRepository movieRepository;

    @Override
    public Page<IMovieDto> findAllMovie(Pageable pageable, String keyword) {
        return movieRepository.findAllMovie(pageable, keyword);
    }

    @Override
    public void deleteById(int idDelete) {
        movieRepository.deleteById(idDelete);
    }

    @Override
    public Optional<Movie> findById(int id) {
        return movieRepository.findById(id);
    }
}
