package projectbackend.repository.movie;

import org.springframework.data.jpa.repository.JpaRepository;
import projectbackend.model.movie.MovieType;

import java.util.List;

public interface IMovieTypeRepository extends JpaRepository<MovieType, Integer> {
}
