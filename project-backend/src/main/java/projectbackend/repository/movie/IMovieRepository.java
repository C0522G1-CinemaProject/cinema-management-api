package projectbackend.repository.movie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import projectbackend.dto.movie.IMovieDto;
import projectbackend.dto.movie.ITimeDto;
import projectbackend.model.movie.Movie;
import projectbackend.model.show_times.Times;

import java.util.List;

public interface IMovieRepository extends JpaRepository<Movie, Integer> {
    @Query(value = "select m.name, m.image, m.start_day as startDay, m.end_day as endDay, m.director, m.film_time as filmTime," +
            " m.trailer, m.movie_type_id as movieType, m.content, m.film_studio as filmStudio, m.actor, m.version " +
            "from movie as m " +
            "join show_times as s on s.movie_id = m.id" +
            "where m.is_delete = 0 and m.id = :id", nativeQuery = true)
    IMovieDto findMovieById(@Param("id") Integer id);

}
