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
    private IMovieRepository iMovieRepository;

    @Override
    public Optional<IMovieDto> getMovieDetail(Integer id) {
        return iMovieRepository.movieDetail(id);
    }

    @Override
    public Page<IMovieDto> findAllHome(String name, Pageable pageable) {
        return iMovieRepository.findAllHome(name, pageable);
    }

    @Override

    public Page<IMovieDto> findAllMovie(Pageable pageable, String keyword) {
        return iMovieRepository.findAllMovie(pageable, keyword);
    }

    @Override
    public void deleteById(int idDelete) {
        iMovieRepository.deleteById(idDelete);
    }

    @Override
    public void addMovie(Movie movie) {
        iMovieRepository.save(movie);
    }

    @Override
    public void editMovie(Movie movie) {
        iMovieRepository.save(movie);
    }

    @Override
    public IMovieDto getMovie(Integer id) {
        return iMovieRepository.findMovieById(id);
    }

    @Override
    public Optional<Movie> finById(Integer id) {
        return iMovieRepository.findById(id);
    }
}
