package projectbackend.repository.movie;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import projectbackend.dto.movie.IMovieDto;
import projectbackend.dto.movie.ITimeDto;

import projectbackend.model.movie.Movie;
import projectbackend.model.show_times.Times;

import java.util.List;

import javax.transaction.Transactional;

public interface IMovieRepository extends JpaRepository<Movie, Integer> {

    @Query(value = "SELECT id, name, start_day as startDay, film_studio as filmStudio, film_time as filmTime, version FROM movie  WHERE name" +
            " LIKE %:keyword% AND is_delete = false", nativeQuery = true)
    Page<IMovieDto> findAllMovie(Pageable pageable,@Param("keyword") String name);

    @Transactional
    @Modifying
    @Query(value = "update movie set is_delete = true where id=:idDelete", nativeQuery = true)
    void deleteById(@Param("idDelete") int idDelete);

    @Query(value = "select m.name, m.image, m.start_day as startDay, m.end_day as endDay, m.director, m.film_time as filmTime," +
            " m.trailer, m.movie_type_id as movieType, m.content, m.film_studio as filmStudio, m.actor, m.version " +
            "from movie as m " +
            "join show_times as s on s.movie_id = m.id" +
            "where m.is_delete = 0 and m.id = :id", nativeQuery = true)
    IMovieDto findMovieById(@Param("id") Integer id);

}
