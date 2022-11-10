package projectbackend.repository.movie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import projectbackend.dto.movie.IMovieDto;
import projectbackend.model.movie.Movie;

import java.util.Optional;

@Repository
@Transactional
public interface IMovieRepository extends JpaRepository<Movie, Integer> {
    @Query(value = "SELECT movie.start_day AS startDay, " +
            "movie.name AS name, " +
            "movie.image AS image, " +
            "movie.director AS director, " +
            "movie.end_day AS endDay, " +
            "movie.film_time AS filmTime," +
            "movie.trailer AS trailer, " +
            "movie.content AS content, " +
            "movie.film_studio AS filmStudio, " +
            "movie.actor AS actor, " +
            "movie.version AS version ," +
            "movie_type.name AS movieType " +
            "            FROM movie " +
            "INNER JOIN movie_type ON movie.movie_type_id = movie_type.id" +
            "             WHERE movie.id = :id", nativeQuery = true)
    Optional<IMovieDto> movieDetail(@Param("id") Integer id);


}
