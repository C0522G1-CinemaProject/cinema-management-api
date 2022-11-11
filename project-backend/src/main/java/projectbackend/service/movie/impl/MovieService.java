package projectbackend.service.movie.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import projectbackend.dto.movie.IMovieDto;
import projectbackend.dto.movie.ITimeDto;
import projectbackend.model.movie.Movie;
import projectbackend.model.show_times.Times;
import projectbackend.repository.movie.IMovieRepository;
import projectbackend.service.movie.IMovieService;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService implements IMovieService {
    @Autowired
    private IMovieRepository  iMovieRepository;


    @Override
    public Optional<IMovieDto> movieDetail(Integer id) {
        return iMovieRepository.movieDetail(id);



    @Override
    public Page<IMovieDto> findAllMovie(String name, Pageable pageable) {
        return iMovieRepository.findAllHome(name, pageable);


    @Override

    public Page<IMovieDto> findAllMovie(Pageable pageable, String keyword) {
        return movieRepository.findAllMovie(pageable, keyword);
    }

    @Override
    public void deleteById(int idDelete) {
        movieRepository.deleteById(idDelete);
    }


    @Override
    public void editMovie(Movie movie) {
        movieRepository.save(movie);
    }

    @Override
    public IMovieDto getMovie(Integer id) {
        return movieRepository.findMovieById(id);
    }

    @Override
    public Optional<Movie> finById(Integer id) {
        return movieRepository.findById(id);
    }
}
