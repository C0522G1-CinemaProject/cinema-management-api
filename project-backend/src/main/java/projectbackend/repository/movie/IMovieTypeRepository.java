package projectbackend.repository.movie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import projectbackend.model.movie.MovieType;
import projectbackend.model.room.Room;

import java.util.List;

public interface IMovieTypeRepository extends JpaRepository<MovieType, Integer> {

    @Query(value = "select name from movie_type where is_delete = 0", nativeQuery = true)
    List<MovieType> findAll();
}
